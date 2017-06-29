package com.ordersystem.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.daofactory.Connpool;
import com.daofactory.DaoFactory;
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
		String sql = "select tt.table_id,tt.table_name,tt.table_state,et.emp_id,tt.table_Capacity,et.emp_name,ct.code_name from table_table tt,ser_tab st,code_table ct,emp_table et where tt.table_id=st.fk_table_id and st.fk_emp_id=et.emp_id and tt.table_state=ct.code_id order by tt.table_id asc";
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
		
		String sql1 = "select ot.order_id from table_table tt,order_table ot where table_state=9 and ot.order_status=11 and ot.order_fk_tabid=tt.table_id and tt.table_id=?";
		String sql2 = "select ft.food_name,ft.food_price,tt.table_name,tt.table_id,odf.order_food_num,ct.code_name,odf.order_food_mark,odf.order_food_id,ot.order_id from code_table ct,"+
				"order_table ot,order_food odf,food_table ft,table_table tt where ot.order_id=odf.fk_order_id and odf.fk_food_id = ft.food_id and ct.code_id=odf.order_food_status and "+
				"ot.order_fk_tabid=tt.table_id and ot.order_status=11 and ot.order_id=?";
		Integer odId = null;
		List<ServiceOrderListBean> solb = null;
		try {
			odId = (Integer) qr.query(sql1, new ScalarHandler(1), table_id);		//��ȡ��ǰ����Ϊtable_idδ����Ķ������
			odId = odId==null?0:odId;
			solb = qr.query("select ft.food_name,ft.food_price,tt.table_name,tt.table_id,odf.order_food_num,ct.code_name,odf.order_food_mark,odf.order_food_id,ot.order_id from code_table ct,order_table ot,order_food odf,food_table ft,table_table tt where ot.order_id=odf.fk_order_id and odf.fk_food_id = ft.food_id and ct.code_id=odf.order_food_status and ot.order_fk_tabid=tt.table_id and ot.order_status=11 and ot.order_id="+odId, new BeanListHandler<ServiceOrderListBean>(ServiceOrderListBean.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return solb;
	}
	
	/**�����ݿ����Ƴ������еĸø���Ʒ��Ϣ
	 * @author hcb
	 * 
	 */
	public int delOrderfood(String foodid) {
		// TODO Auto-generated method stub
		
		String sql1 = "select order_food_status from order_food where order_food_id=?";		//��ѯ���ݿ��и�id��
		String sql2 = "delete order_food where order_food_id=?";
		Object[] params=new Object[]{foodid};
		int i = -1;
		try {
			Integer status = (Integer) qr.query(sql1, new ScalarHandler(1), foodid);
			if (status==1) {
				i = DaoFactory.executeUpdate(sql2, params);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	/**�ߵ��ķ���
	 * @author hcb
	 * 
	 */
	public int reminder(String tableid) {
		// TODO Auto-generated method stub
		//sql1 Ϊ�鵽�����������ڳԷ��Ķ������
		//sql2Ϊ�ҵ��ö�����ǰ�Ĵߵ�����
		//sql3Ϊ���µ�ǰ��Ҫ���¶����ߵ�����
		String sql1 = "select ot.order_id from table_table tt,order_table ot where table_state=9 and ot.order_status=11 and ot.order_fk_tabid=tt.table_id and tt.table_id=?";
		String sql2 = "select order_press from order_food,order_table where fk_order_id=order_id and order_id=?";
		String sql3 = "update order_food set order_press=? where fk_order_id=?";
		int i = -1;
		try {
			Integer orderid = (Integer) qr.query(sql1, new ScalarHandler(1), tableid);	//�鵽������ǰ�Ķ������
			orderid = orderid==null?0:orderid;
			Integer num = (Integer) qr.query(sql2, new ScalarHandler(1), orderid);		//�鵽��ǰ�����Ĵߵ�����
			num = num==null?1:++num;
			Object[] params = new Object[]{num,orderid};
			i = DaoFactory.executeUpdate(sql3, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	/**��������Ӳ˵ķ���
	 * @author hcb
	 * 
	 */
	public Integer addOrderfood(String foodid, String tableid) {
		// TODO Auto-generated method stub
		//sql1Ϊ��ѯ�������������ڳԷŵĶ������
		//sql2Ϊ�򶩵���Ʒ���в����¼Ӳ˵Ĳ�Ʒ��¼
		String sql1 = "select ot.order_id from table_table tt,order_table ot where table_state=9 and ot.order_status=11 and ot.order_fk_tabid=tt.table_id and tt.table_id=?";
		String sql2 = "insert into order_food (fk_order_id,fk_food_id,order_food_num,order_food_status) values(?,?,1,1)";
		Integer i = -1;
		try {
			Integer orderid = (Integer) qr.query(sql1, new ScalarHandler(1),tableid);
			Object[] params = new Object[]{orderid,foodid};
			i = DaoFactory.executeUpdate(sql2, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	/**���ù��õķ��� ����Ϊ ͨ��ǰ̨����������id�����ݿ��в��ҵ������ŵ�ǰ�Ͳ͵Ķ������
	 * @author hcb
	 * @tabid Ϊǰ�˴��ص�����id
	 */
	public Integer searchOrderId(String tabid){
		//String sql1 = "select ot.order_id from table_table tt,order_table ot where table_state=9 and ot.order_status=11 and ot.order_fk_tabid=tt.table_id and tt.table_id=?";
		Integer orderid = null;
		try {
			orderid = (Integer) qr.query("select ot.order_id from table_table tt,order_table ot where table_state=9 and ot.order_status=11 and ot.order_fk_tabid=tt.table_id and tt.table_id="+tabid, new ScalarHandler(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderid;
	}

	/**�ú�������Ϊ����ǰ�ȼ��ò����Ƿ���δ����Ĳ�(������δ��)
	 * @author hcb
	 * 
	 */
	public Integer checkfood(String tbid) {
		// TODO Auto-generated method stub
		Integer orderId = searchOrderId(tbid);
		System.out.println(orderId+"orderIdorderId");
		String sql1 = "select COUNT(*) from order_food where fk_order_id =? and order_food_status = 1";
		String sql2 = "select COUNT(*) from order_food where fk_order_id =? and order_food_status = 2";
		Object[] params = new Object[]{orderId};
		int r=0;
		try {
			Integer i = (Integer) qr.query("select COUNT(*) from order_food where fk_order_id ="+orderId+" and order_food_status = 1", new ScalarHandler(1));
			Integer j = (Integer) qr.query("select COUNT(*) from order_food where fk_order_id ="+orderId+" and order_food_status = 2", new ScalarHandler(1));
			//Integer i = (Integer) DaoFactory.execQuery(sql1, params).get(0).get(0);
			//Integer j = (Integer) DaoFactory.execQuery(sql2, params).get(0).get(0);
			i=i==null?0:i;
			j=j==null?0:0;
			r=i+j;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	
	/**�������ݿ�״̬ �Լ��������ݵķ��� 
	 * @author hcb
	 * 
	 */
	public Integer updateStatus(String sql,Object[] params){
		return DaoFactory.executeUpdate(sql, params);
	}
	
	/**�õ�һ����Ԫ������ֵ�ķ��� �����ܽ��
	 * @author hcb
	 * 
	 */
	public Integer findone(String sql){
		Integer num = null;
		try {
			num = (Integer) qr.query(sql, new ScalarHandler(1));
			num = num==null?0:num;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	
	
}
