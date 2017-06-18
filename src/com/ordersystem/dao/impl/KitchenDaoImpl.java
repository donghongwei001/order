package com.ordersystem.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.daofactory.Connpool;
import com.ordersystem.dao.KitchenDao;
import com.ordersystem.domain.SortKitchenFoodBean;
import com.ordersystem.domain.WaitFoodBean;

public class KitchenDaoImpl implements KitchenDao {
	
	/**从数据库中得到所有待做菜品
	 * @author hcb
	 * 
	 */
	Connpool cp = new Connpool();
	
	/** (non-Javadoc)sql1是
	 * @see com.ordersystem.dao.KitchenDao#showWaitFood()
	 */
	public List<SortKitchenFoodBean> showWaitFood(String sql1,String sql2) {
		// TODO Auto-generated method stub
		setDbweight(sql2); //排序前现在数据库中设置好权重
		return mergeFood(sql2);	//调用并菜函数
		}
	
	//并菜的函数
	private List<SortKitchenFoodBean> mergeFood(String sql2) {
		// TODO Auto-generated method stub
		List<WaitFoodBean> wfb = showFood(sql2);	//按权重排序从数据库中查出数据
		if (wfb.size()==0) {
			return null;
		}
		List<SortKitchenFoodBean> MergeList = new ArrayList<SortKitchenFoodBean>();
		if(MergeList.size()<15){
			for (int i = 0; i < wfb.size(); i++) {
				SortKitchenFoodBean skfb = new SortKitchenFoodBean();	//菜品封装类
				int flag=-1;	//定义一个标志 判断是否合并了该菜
				int fNum = wfb.get(i).getFood_num();
				String tNum = wfb.get(i).getTable_name();	//获得该菜的桌号
				String idString = wfb.get(i).getOrder_food_id()+"";		//菜品id
				String food_name = wfb.get(i).getFood_name();		//菜品名称
				String orderId = wfb.get(i).getFk_order_id();		//订单id  (记录用来更新订单最后上菜时间)
				//System.out.println(food_name);
				String order_food_mark = wfb.get(i).getOrder_food_mark();
				int maxMerge = wfb.get(i).getFood_maxcb();
				//添加入集合前先用for对mergelist进行遍历  判断是否能进行合并
				for (int j = 0; j < MergeList.size(); j++) {
					if (food_name.equals(MergeList.get(j).getWfb().getFood_name())) {
					//if (food_name.equals(MergeList.get(j).getWfb().getFood_name())&&order_food_mark.equals(MergeList.get(j).getWfb().getOrder_food_mark())&&maxMerge > MergeList.get(j).getFoodnum()) {
						System.out.println("符合并菜条件");
						flag = 1;
						fNum += MergeList.get(j).getFoodnum();	//更新数量
						tNum = MergeList.get(j).getTabid()+","+tNum;//更新桌号
						idString = MergeList.get(j).getOrder_food_id()+"-"+idString;//更新id编号
						orderId = MergeList.get(j).getOrderId()+"-"+orderId;	//更新订单id
						System.out.println("合并后的订单编号是:"+orderId);
						MergeList.get(j).setFoodnum(fNum);
						MergeList.get(j).setOrder_food_id(idString);
						MergeList.get(j).setTabid(tNum);
						MergeList.get(j).setOrderId(orderId);
					}
				}
				skfb.setFoodnum(fNum);
				skfb.setWfb(wfb.get(i));
				skfb.setOrder_food_id(idString);
				skfb.setTabid(tNum);
				skfb.setOrderId(orderId);
				if (flag==1) {
					System.out.println();
					continue;
				}
				MergeList.add(skfb);
			}
	}
		return MergeList;
	}

	/**设置数据库中的权重字段
	 * @author hcb
	 * 
	 */
	private void setDbweight(String sql) {
		List<WaitFoodBean> wfb = showFood(sql);
		if (wfb.size()==0) {
			return ;
		}
		//System.out.println("---KitchenDaoImpl-------"+wfb.size());
		 
		//对从数据库取出的每个菜品list集合进行 遍历并菜封装
		List<SortKitchenFoodBean> list = new ArrayList<SortKitchenFoodBean>();	//用来存放封装的菜品类对象
		for (int i = 0; i < wfb.size(); i++) {
			//System.out.println(wfb.get(i));
			double weight = 0;	//定义权重变量
			weight = (0.3*wfb.get(i).getLasttime()+0.3*wfb.get(i).getTime()+0.4*wfb.get(i).getOrder_press()*100)*wfb.get(i).getFood_time();
			//System.out.println(weight);
			QueryRunner qr = new QueryRunner(cp.getBds());
			String upsql = "update order_food set order_food_weight=? where order_food_id=?";
			try {
				qr.update(upsql, weight,wfb.get(i).getOrder_food_id());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
	}
		
	/**通过编写sql语句在数据库中查找菜品 并把数据封装在WaitFoodBean类中  且返回list集合
	 * @author hcb
	 * 
	 */
	public List<WaitFoodBean> showFood(String sql) {
		
		QueryRunner qr = new QueryRunner(cp.getBds());
		List<WaitFoodBean> wfb = null;  //-----wfb存放的是数据库返回的 waitfoodbean对象
		try {
			wfb = qr.query(sql, new BeanListHandler<WaitFoodBean>(WaitFoodBean.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return wfb;
	}
			
	public static void main(String[] args) {
		KitchenDaoImpl kdi = new KitchenDaoImpl();
		String sql1 ="select odf.order_food_id,odf.order_food_weight,ot.order_id 'fk_order_id',tt.table_id 'table_name' , ft.food_name 'food_name',odf.order_food_mark 'order_food_mark',DATEDIFF(SS,ot.order_lasttime,GETDATE()) 'lasttime',DATEDIFF(SS,ot.order_time,GETDATE()) 'time',et.emp_name 'emp_name',odf.order_press 'order_press',ft.food_time 'food_time',odf.order_food_num 'food_num',ft.food_merge 'food_maxcb' from order_food odf,order_table ot,emp_table et,food_table ft,table_table tt"+
				" where odf.fk_food_id = ft.food_id and odf.fk_order_id = ot.order_id  and ot.order_fk_empid = et.emp_id and ot.order_fk_tabid = tt.table_id";
		String sql2 ="select odf.order_food_id,odf.order_food_weight,ot.order_id 'fk_order_id',tt.table_id 'table_name' , ft.food_name 'food_name',odf.order_food_mark 'order_food_mark',DATEDIFF(SS,ot.order_lasttime,GETDATE()) 'lasttime',DATEDIFF(SS,ot.order_time,GETDATE()) 'time',et.emp_name 'emp_name',odf.order_press 'order_press',ft.food_time 'food_time',odf.order_food_num 'food_num',ft.food_merge 'food_maxcb' from order_food odf,order_table ot,emp_table et,food_table ft,table_table tt"+
				" where odf.fk_food_id = ft.food_id and odf.fk_order_id = ot.order_id  and ot.order_fk_empid = et.emp_id and ot.order_fk_tabid = tt.table_id order by order_food_weight desc";
		List<SortKitchenFoodBean> list = kdi.showWaitFood(sql1,sql2);
		//ArrayList<ArrayList> list2 = DaoFactory.execQuery(sql, null);
		for (int i = 0; i < list.size(); i++) {
			
			System.out.println(list.get(i));
		}
	}
	/**查询数据库中统计数据的方法并返回统计的结果(count(*))
	 * @author hcb
	 * 
	 */
		public String findCount(String sql) {
			// TODO Auto-generated method stub
			QueryRunner qr = new QueryRunner(cp.getBds());
			String query = null;
			try {
				query = qr.query(sql, new ScalarHandler(1) ).toString();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return query;
		}
		
	/**更新数据库的方法(一次更新一个参数的方法)
	 * param1为需要更新的参数
	 * param2位where后面的条件
	 * @author hcb
	 * 
	 */
	public void updateDataBase(String sql, String param1, String param2) {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(cp.getBds());
		try {
			qr.update(sql, param1,param2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**更新数据库的方法(一次更新两个参数的方法)
	 * param1为需要更新的参数
	 * param2位where后面的条件
	 * @author hcb
	 * 
	 */
	public void updateDataBase(String sql, String param1, String param2,String param3) {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(cp.getBds());
		try {
			qr.update(sql, param1,param2,param3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
