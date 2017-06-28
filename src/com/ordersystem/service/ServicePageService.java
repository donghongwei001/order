package com.ordersystem.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.daofactory.Connpool;
import com.ordersystem.dao.impl.ServicePageImpl;
import com.ordersystem.domain.DisheBean;
import com.ordersystem.domain.ServiceOrderListBean;
import com.ordersystem.domain.ServiceTable;
import com.ordersystem.entity.MyFormat;

public class ServicePageService {

	Connpool cp = new Connpool();
	QueryRunner qr = new QueryRunner(cp.getDataSource());
	
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

	/**����Աҳ���������Ӳ˵ķ���
	 * @author hcb
	 * 
	 */
	public Integer addOrderfood(String foodid, String tableid) {
		// TODO Auto-generated method stub
		Integer i = spi.addOrderfood(foodid,tableid);
		return i;
	}
	
	/**�ú�������Ϊ����ǰ�ȼ��ò����Ƿ���δ����Ĳ�
	 * @author hcb
	 * 
	 */
	public int checkfood(String tbid) {
		// TODO Auto-generated method stub
		Integer i = spi.checkfood(tbid);
		return i;
	}
	
	/**�ú����Ĺ����Ǹ���ǰ�˴��ص����Ž���
	 * @author hcb
	 * 	1.�õ���Ʒ����Ӧ���ܽ��(����������)
	 *  2.�������ݿⶩ���Ľ��
	 *  3.�ı�����״̬Ϊ ����ɨ
	 *  4.�ı䶩��״̬Ϊ ����
	 * 
	 */
	public Integer paymoney(String tbid,String count) {
		// TODO Auto-generated method stub
		Integer orderId = spi.searchOrderId(tbid);		//�õ�����id
		String sql = "update table_table set table_state=10 where table_id=?";
		Object[] params = new Object[]{tbid};
		String sql1 = "update order_table set order_status=12,order_money=? where order_id=?";
		Object[] param1 = new Object[]{count,orderId};
		//Integer status = spi.updateStatus(sql1,param1);		//���¶���״̬Ϊ�ѽ����붩�����еĽ��	�Լ����¸ö�����ŵ�״̬Ϊ�ѽ���
		Integer status = -1;
		try {
			status = qr.update("update order_table set order_status=12,order_money="+count+" where order_id="+orderId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	//���¶���״̬Ϊ�ѽ����붩�����еĽ��	�Լ����¸ö�����ŵ�״̬Ϊ�ѽ���
		if (status==1) {
			spi.updateStatus(sql,params);		//��������״̬
		}
		
		return status;
	}

	/**��̨�����ı�����״̬Ϊ����
	 * @author hcb
	 * 
	 */
	public Integer updateTable(String tableid) {
		// TODO Auto-generated method stub
		String sql = "update  table_table set table_state=8 where table_id= ? and table_state=10";
		Object[] params = new Object[]{tableid};
		return spi.updateStatus(sql, params);
	}

	/**����Ա���濪̨�ķ���
	 * @author hcb
	 * �򶩵����в���һ��������Ϣ
	 * ������״̬��Ϊռ��
	 */
	public Integer starteat(String tableid,String empid) {
		// TODO Auto-generated method stub
		
		String sql = "insert into order_table (order_time,order_fk_tabid,order_money,order_fk_empid,order_lasttime,order_status) values (?,?,?,?,?,?)";
		String date = MyFormat.getLastServingFormat().format(new Date());
		Object[] params = new Object[]{date,tableid,0,empid,date,11};
		Integer i = spi.updateStatus(sql, params);		//�򶩵����в���һ��������¼
		Integer j = 0;
		String sql2 = "update table_table set table_state=9 where table_id=? and table_state=8";
		Object[] param = new Object[]{tableid};
		if(i>0){
			j=spi.updateStatus(sql2, param);
		}
		return j;
	}

	/**ȡ�����з���Ա�ķ��� ��������״̬Ϊռ��
	 * @author hcb
	 * 
	 */
	public Integer cancelcall(String tableid) {
		// TODO Auto-generated method stub
		String sql = "update table_table set table_state=9 where table_state=13 and table_id=?";
		Object[] params = new Object[]{tableid};
		return spi.updateStatus(sql, params);
	}

	/**�������ݿⶩ���еĲ�Ʒ���� ����Ա�����е��޸Ĳ�Ʒ����
	 * @author hcb
	 * 1.���Ȳ�ѯ��������ǰ�Է��Ķ������
	 * 2.��ѯ���ò����Ĳ�Ʒ���
	 * 3.���¸ò˵�����
	 * 
	 */
	public Integer updatefoodnum(String tabid, String foodname, String newnum) {
		// TODO Auto-generated method stub
		Integer orderId = spi.searchOrderId(tabid);		//�õ������ӵ����ڳԷ��Ķ���id
		String sql1 = "select food_id from food_table where food_name='"+foodname+"'";		//���ָ�������Ĳ�Ʒ���
		Integer foodid = spi.findone(sql1);    			//�õ�����Ĳ�Ʒ�����
		String sql = "update order_food set order_food_num=? where fk_order_id=? and fk_food_id=? and order_food_status=1";
		Object[] params = new Object[]{newnum,orderId,foodid};
		return spi.updateStatus(sql, params);
	}
	

}
