package com.ordersystem.service;

import java.util.List;

import com.ordersystem.dao.impl.KitchenDaoImpl;
import com.ordersystem.domain.FoodBean;
import com.ordersystem.domain.SortKitchenFoodBean;
import com.ordersystem.domain.WaitFoodBean;

public class KitchenService {
	KitchenDaoImpl kdi = new KitchenDaoImpl();
	
	/**查询显示待做的菜品  并且按权重排序
	 * @author hcb
	 * 
	 */
	public List<SortKitchenFoodBean> showWaitFood(String foodStatus) {
		String sql = "select odf.order_food_id,odf.order_food_weight,ot.order_id 'fk_order_id',tt.table_id 'table_name' , ft.food_name 'food_name',odf.order_food_mark 'order_food_mark',DATEDIFF(SS,ot.order_lasttime,GETDATE()) 'lasttime',DATEDIFF(SS,ot.order_time,GETDATE()) 'time',et.emp_name 'emp_name',odf.order_press 'order_press',ft.food_time 'food_time',odf.order_food_num 'food_num',ft.food_merge 'food_maxcb' from order_food odf,order_table ot,emp_table et,food_table ft,table_table tt"+
				" where odf.fk_food_id = ft.food_id and odf.fk_order_id = ot.order_id  and ot.order_fk_empid = et.emp_id and ot.order_fk_tabid = tt.table_id and odf.order_food_status="+foodStatus+" order by order_food_weight desc";
		return kdi.showWaitFood(sql,sql);
		
	}
	
	
	/**此方法用来查询所有已做的菜
	 * @author hcb
	 * 
	 */
	public List<WaitFoodBean> showDoneFood() {
		// TODO Auto-generated method stub
		String sql = "select odf.order_food_id,odf.order_food_weight,ot.order_id 'fk_order_id',tt.table_id 'table_name' , ft.food_name 'food_name',odf.order_food_mark 'order_food_mark',DATEDIFF(SS,ot.order_lasttime,GETDATE()) 'lasttime',DATEDIFF(SS,ot.order_time,GETDATE()) 'time',et.emp_name 'emp_name',odf.order_press 'order_press',ft.food_time 'food_time',odf.order_food_num 'food_num',ft.food_merge 'food_maxcb' from order_food odf,order_table ot,emp_table et,food_table ft,table_table tt"+
				" where odf.fk_food_id = ft.food_id and odf.fk_order_id = ot.order_id  and ot.order_fk_empid = et.emp_id and ot.order_fk_tabid = tt.table_id and odf.order_food_status=3";
		return kdi.showFood(sql);
	}

	/**查找厨房待做的菜品总数量(徽章显示部分)
	 * @author hcb
	 * 
	 */
	public String findCount() {
		// TODO Auto-generated method stub
		String sql = "select COUNT(*) from order_food odf,order_table ot,emp_table et,food_table ft,table_table tt"+
				" where odf.fk_food_id = ft.food_id and odf.fk_order_id = ot.order_id  and ot.order_fk_empid = et.emp_id and ot.order_fk_tabid = tt.table_id and odf.order_food_status=1";
		
		return kdi.findCount(sql);
	}

	/**更新数据库菜品状态的方法
	 * @author hcb
	 * 
	 */
	public void updateStatus(String id,String status) {
		// TODO Auto-generated method stub
		
		if (id.indexOf("-")>0) {
			System.out.println("-------if---------");
			String[] params = id.split("-");
			System.out.println("params长度:"+params.length);
			for (int i = 0; i < params.length; i++) {
				System.out.println(params[i]);
				String sql="update order_food set order_food_status=? where order_food_id in (?)";
				kdi.updateStatus(sql,status,params[i]);
			}
		}else{
			System.out.println("else");
			String sql="update order_food set order_food_status=? where order_food_id in (?)";
			kdi.updateStatus(sql,status,id);
		}
	}

}
