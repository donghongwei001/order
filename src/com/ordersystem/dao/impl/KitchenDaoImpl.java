package com.ordersystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.daofactory.Connpool;
import com.ordersystem.dao.KitchenDao;
import com.ordersystem.domain.SortKitchenFoodBean;
import com.ordersystem.domain.WaitFoodBean;

public class KitchenDaoImpl implements KitchenDao {

	public List<SortKitchenFoodBean> showWaitFood() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**从数据库中得到所有待做菜品
	 * @author hcb
	 * 
	 */
	/*Connpool cp = new Connpool();
	
	 (non-Javadoc)
	 * @see com.ordersystem.dao.KitchenDao#showWaitFood()
	 
	public List<SortKitchenFoodBean> showWaitFood() {
		// TODO Auto-generated method stub
		//Connection conn = cp.getConn();
		QueryRunner qr = new QueryRunner(cp.getBds());
		String sql = "";
		List<WaitFoodBean> wfb = null;  //-----wfb存放的是数据库返回的 waitfoodbean对象
		try {
			wfb = qr.query(sql, new BeanListHandler<WaitFoodBean>(WaitFoodBean.class), "params");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (wfb.size()==0) {
			return null;
		}
		
		*//**对从数据库取出的每个菜品list集合进行 遍历并菜封装
		 * @author hcb
		 * 
		 *//*
		List<SortKitchenFoodBean> list = new ArrayList<SortKitchenFoodBean>();	//用来存放封装鸡皮的菜品类对象
		for (int i = 0; i < wfb.size(); i++) {		
			
			//实例化菜品封装类
			SortKitchenFoodBean skfb = new SortKitchenFoodBean();
			skfb.setWfb(wfb.get(i));
			
			//定义权重,给权重属性赋值
			double weight = 0;	//定义权重变量
			weight = (0.3*wfb.get(i).getLasttime()+0.3*wfb.get(i).getTime()+0.4*wfb.get(i).getOrder_press()*100)*wfb.get(i).getFood_time();
			skfb.setWeight(weight);
			
			int num2 = wfb.get(i).getFood_num(); 		//获得tab桌的该菜的数量
			skfb.setFoodnum(num2);
			
			//并菜 先循环查看list集合里面是否存在相同的菜
			int flag = 0;	//定义一个标志 用来判断是否并菜了
			for (int j = 0; j < list.size(); j++) {
				//判断 如果该菜的菜名和备注口味相同则可以合并该菜
				//限制该菜的最大合并数
				//并菜后需显示桌号对应的该菜数量
				if (wfb.get(i).getFood_name().equals(list.get(j).getWfb().getFood_name()) && wfb.get(i).getOrder_food_mark().equals(list.get(j).getWfb().getOrder_food_mark())) {
					
					int num = list.get(j).getFoodnum();		//如果存在相同需要并菜的菜品 则获得当前已合并的数量
					String tab = list.get(j).getWfb().getTable_name();	//得到之前已存在该菜的桌号
					//判断list中的这个菜是否是第一次并菜
					if (tab.contains(":")) {
						tab = tab+","+wfb.get(i).getTable_name()+":"+wfb.get(i).getFood_num();
					}else {
						tab = tab+":"+num+","+wfb.get(i).getTable_name()+":"+wfb.get(i).getFood_num();		//+","+
					}
					list.get(j).getWfb().setTable_name(tab);		//如果需要并菜把重新组装好的  座号:菜数量  重新赋值给原来的座号属性
					flag=1;		//更改标志
					num2 += num;	
					list.get(j).setFoodnum(num2);		//如果需要并菜 则更新包装类中的菜品数量
				}
			}
			if(flag==0)
			list.add(skfb);
		}//并菜结束
		
		*//**对已经封装好的list集合进行按权重排序
		 * @author hcb
		 * 
		 *//*
		for (int j = 0; j < list.size()-1; j++) {
			for (int j2 = 1; j2 < list.size()-j; j2++) {
				if (list.get(j).getWeight()<list.get(j+1).getWeight()) {
					SortKitchenFoodBean temp = list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1, temp);
				}
			}
		}
		return list;
	}*/
}
