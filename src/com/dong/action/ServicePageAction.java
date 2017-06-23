package com.dong.action;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.ordersystem.domain.ServiceOrderListBean;
import com.ordersystem.domain.ServiceTable;
import com.ordersystem.service.ServicePageService;

public class ServicePageAction extends BaseAction implements ModelDriven<ServiceTable> {
	ServicePageService sps = new ServicePageService();
	
	public ServiceTable getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**查询显示桌子状态
	 * @author hcb
	 * serv_*
	 */
	public String showTable(){
		List<ServiceTable> tbList = sps.showTable();
		Integer occupy = sps.countCategory(9);	//查询正在使用的餐桌总数
		Integer rest = sps.countCategory(8);		//查询没有使用的餐桌总数
		Integer dirty = sps.countCategory(10);		//查询需要清扫的餐桌总数
		Integer total = sps.countOrderStatus(11);		//查询当天未付款的订单总数
		Integer payed = sps.countOrderStatus(12);	//查询当天已付款的订单总数
		total = total==null?0:total;
		payed = payed==null?0:payed;
		super.setsession("tbList", tbList);
		super.setsession("occupy",occupy );
		super.setsession("rest", rest);
		super.setsession("dirty", dirty);
		super.setsession("total", total);
		super.setsession("payed", payed);
		return "succ";
	}
	
	/**
	 * @author hcb
	 * http://localhost:8080/Ordersystem/admin/products/serv_orderDetails.action?table_id=1
	 */
	public String orderDetails(){
		System.out.println("-------orderDetails------");
		String table_id = super.getparameter("table_id");
		System.out.println(table_id+"***table_id***");
		List<ServiceOrderListBean> solb = sps.showOrderDetails(table_id);
		super.setsession("solb", solb);
		return "succ";
	}
}



