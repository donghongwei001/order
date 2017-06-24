package com.ordersystem.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.daofactory.Connpool;
import com.ordersystem.domain.ServiceOrderListBean;
import com.ordersystem.domain.ServiceTable;
import com.ordersystem.entity.MyFormat;

public class ServicePageImpl {
	Connpool cp = new Connpool();
	QueryRunner qr = new QueryRunner(cp.getDataSource());
	/**��ѯ���ݿ��е����Ӳ���ʾ�ڷ���Ա����
	 * @author hcb
	 * 
	 */
	public List<ServiceTable> showTable() {
		// TODO Auto-generated method stub
		String sql = "select tt.table_id,tt.table_name,tt.table_state,et.emp_id,tt.table_Capacity,et.emp_name,ct.code_name from table_table tt,ser_tab st,code_table ct,emp_table et where tt.table_id=st.fk_table_id and st.fk_emp_id=et.emp_id and tt.table_state=ct.code_id";
		List<ServiceTable> tbList = null;
		try {
			tbList = qr.query(sql, new BeanListHandler<ServiceTable>(ServiceTable.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tbList;
	}
	
	/**ͳ������״̬����
	 * @author hcb
	 * 
	 */
	public Integer countCategory(String sql, int i) {
		// TODO Auto-generated method stub
		Integer count = null;
		try {
			count = (Integer) qr.query(sql, new ScalarHandler(1),i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	/**ͳ�ƶ�����״̬�µ�����
	 * @author hcb
	 * 
	 */
	public Integer countOrderStatus(int i) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from order_table where order_time between '"+MyFormat.getDayBegin()+"' and '"+MyFormat.getDateformat().format(new Date())+"' and order_status=?";
		Integer count = null;
		try {
			count = (Integer) qr.query(sql, new ScalarHandler(1),i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	/**��ʾͨ��������Ų�ѯ��ǰ�����Ͳ͵Ķ�������
	 * @author hcb
	 * 
	 */
	public List<ServiceOrderListBean> showOrderDetails(String table_id) {
		// TODO Auto-generated method stub
		//sql1 Ϊ�鵽�����������ڳԷ��Ķ������
		//sql2 Ϊ��ѯsql1�鵽�Ķ�����������в�Ʒ����Ϣ��¼
		
		String sql1 = "select ot.order_id from table_table tt,order_table ot where table_state=9 and ot.order_fk_tabid=tt.table_id and tt.table_id=?";
		String sql2 = "select food_name,food_price,table_name,table_id,order_food_num,order_food_mark,order_food_id,order_id from " +
				"order_table,order_food,food_table,table_table where order_id=fk_order_id and fk_food_id = food_id and " +
				"order_fk_tabid=table_id and order_status=11 and order_id=?";
		Integer odId = null;
		List<ServiceOrderListBean> solb = null;
		try {
			odId = (Integer) qr.query(sql1, new ScalarHandler(1), table_id);		//��ȡ��ǰ����Ϊtable_idδ����Ķ������
			System.out.println("**********"+odId);
			odId = odId==null?0:odId;
			solb = qr.query(sql2, new BeanListHandler<ServiceOrderListBean>(ServiceOrderListBean.class), odId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return solb;
	}
	
	/**
	 * @author hcb
	 * 
	 */

}
