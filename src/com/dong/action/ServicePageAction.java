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
	
	/**��ѯ��ʾ����״̬
	 * @author hcb
	 * serv_*
	 */
	public String showTable(){
		List<ServiceTable> tbList = sps.showTable();
		Integer occupy = sps.countCategory(9);	//��ѯ����ʹ�õĲ�������
		Integer rest = sps.countCategory(8);		//��ѯû��ʹ�õĲ�������
		Integer dirty = sps.countCategory(10);		//��ѯ��Ҫ��ɨ�Ĳ�������
		Integer total = sps.countOrderStatus(11);		//��ѯ����δ����Ķ�������
		Integer payed = sps.countOrderStatus(12);	//��ѯ�����Ѹ���Ķ�������
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



