package com.ordersystem.service;

import java.util.List;

import com.ordersystem.dao.impl.ServicePageImpl;
import com.ordersystem.domain.DisheBean;
import com.ordersystem.domain.ServiceOrderListBean;
import com.ordersystem.domain.ServiceTable;

public class ServicePageService {

	ServicePageImpl spi = new ServicePageImpl();
	/**��ѯ����״̬�ڷ���Ա������ʾ
	 * @author hcb
	 * 
	 */
	public List<ServiceTable> showTable() {
		// TODO Auto-generated method stub
		List<ServiceTable> tbList = spi.showTable();
		return tbList;
	}
	
	/**ͳ�Ƹ���״̬����������
	 * @author hcb
	 * 
	 */
	public Integer countCategory(int i) {
		String sql = "select count(*) from table_table where table_state=?";
		Integer count = spi.countCategory(sql,i);
		return count;
	}

	/**��ѯ����״̬����
	 * @author hcb
	 * 
	 */
	public Integer countOrderStatus(int i) {
		// TODO Auto-generated method stub// select count(*) from order_table where order_time between '2017-06-18' and '2017-06-19' and order_status=11
		Integer count = spi.countOrderStatus(i);
		return count;
	}
	
	/**��ѯ���������´����˵Ķ�����Ʒ�б�
	 * @author hcb
	 * 
	 */
	public List<ServiceOrderListBean> showOrderDetails(String table_id) {
		// TODO Auto-generated method stub
		List<ServiceOrderListBean> solb = spi.showOrderDetails(table_id);
		return solb;
	}

	/**ͨ��order_food_id�Ƴ����ݿ��еĸò�
	 * @author hcb
	 * 
	 */
	public int delOrderfood(String foodid) {
		// TODO Auto-generated method stub
		int i = spi.delOrderfood(foodid);
		return i;
	}


	/**�ߵ��ķ���
	 * @author hcb
	 * 
	 */
	public int reminder(String tableid) {
		// TODO Auto-generated method stub
		int i = spi.reminder(tableid);
		return i;
	}

	/**��ҳ��ѯ��ʾ���ݿ��е����еĲ�Ʒ
	 * @author hcb
	 * ����  ͨ������dishesservice��ķ���ʵ�ִ˹���
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
