package com.ordersystem.service;

import java.util.List;

import com.ordersystem.dao.impl.ServicePageImpl;
import com.ordersystem.domain.DisheBean;
import com.ordersystem.domain.ServiceOrderListBean;
import com.ordersystem.domain.ServiceTable;

public class ServicePageService {

	ServicePageImpl spi = new ServicePageImpl();
	/**查询桌子状态在服务员界面显示
	 * @author hcb
	 * 
	 */
	public List<ServiceTable> showTable() {
		// TODO Auto-generated method stub
		List<ServiceTable> tbList = spi.showTable();
		return tbList;
	}
	
	/**统计各种状态的桌子总数
	 * @author hcb
	 * 
	 */
	public Integer countCategory(int i) {
		String sql = "select count(*) from table_table where table_state=?";
		Integer count = spi.countCategory(sql,i);
		return count;
	}

	/**查询订单状态总数
	 * @author hcb
	 * 
	 */
	public Integer countOrderStatus(int i) {
		// TODO Auto-generated method stub// select count(*) from order_table where order_time between '2017-06-18' and '2017-06-19' and order_status=11
		Integer count = spi.countOrderStatus(i);
		return count;
	}
	
	/**查询出该桌号下待结账的订单菜品列表
	 * @author hcb
	 * 
	 */
	public List<ServiceOrderListBean> showOrderDetails(String table_id) {
		// TODO Auto-generated method stub
		List<ServiceOrderListBean> solb = spi.showOrderDetails(table_id);
		return solb;
	}

	/**通过order_food_id移除数据库中的该菜
	 * @author hcb
	 * 
	 */
	public int delOrderfood(String foodid) {
		// TODO Auto-generated method stub
		int i = spi.delOrderfood(foodid);
		return i;
	}


	/**催单的方法
	 * @author hcb
	 * 
	 */
	public int reminder(String tableid) {
		// TODO Auto-generated method stub
		int i = spi.reminder(tableid);
		return i;
	}

	/**分页查询显示数据库中的已有的菜品
	 * @author hcb
	 * 忽略  通过调用dishesservice类的方法实现此功能
	 */
	public List<DisheBean> showmenuList() {
		// TODO Auto-generated method stub
		
		return null;
	}

	public Integer addOrderfood(String foodid, String tableid) {
		// TODO Auto-generated method stub
		Integer i = spi.addOrderfood(foodid,tableid);
		return i;
	}
	

}
