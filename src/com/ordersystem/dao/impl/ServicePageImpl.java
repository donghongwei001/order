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
	/**查询数据库中的桌子并显示在服务员界面
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
	
	/**统计桌子状态总数
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

	/**统计订单各状态下的总数
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

	/**显示通过餐桌编号查询当前餐桌就餐的订单详情
	 * @author hcb
	 * 
	 */
	public List<ServiceOrderListBean> showOrderDetails(String table_id) {
		// TODO Auto-generated method stub
		//sql1 为查到该桌号下正在吃饭的订单编号
		//sql2 为查询sql1查到的订单编号下所有菜品的信息记录
		
		String sql1 = "select ot.order_id from table_table tt,order_table ot where table_state=9 and ot.order_status=11 and ot.order_fk_tabid=tt.table_id and tt.table_id=?";
		String sql2 = "select ft.food_name,ft.food_price,tt.table_name,tt.table_id,odf.order_food_num,ct.code_name,odf.order_food_mark,odf.order_food_id,ot.order_id from code_table ct,"+
				"order_table ot,order_food odf,food_table ft,table_table tt where ot.order_id=odf.fk_order_id and odf.fk_food_id = ft.food_id and ct.code_id=odf.order_food_status and "+
				"ot.order_fk_tabid=tt.table_id and ot.order_status=11 and ot.order_id=?";
		Integer odId = null;
		List<ServiceOrderListBean> solb = null;
		try {
			odId = (Integer) qr.query(sql1, new ScalarHandler(1), table_id);		//获取当前桌号为table_id未付款的订单编号
			odId = odId==null?0:odId;
			solb = qr.query("select ft.food_name,ft.food_price,tt.table_name,tt.table_id,odf.order_food_num,ct.code_name,odf.order_food_mark,odf.order_food_id,ot.order_id from code_table ct,order_table ot,order_food odf,food_table ft,table_table tt where ot.order_id=odf.fk_order_id and odf.fk_food_id = ft.food_id and ct.code_id=odf.order_food_status and ot.order_fk_tabid=tt.table_id and ot.order_status=11 and ot.order_id="+odId, new BeanListHandler<ServiceOrderListBean>(ServiceOrderListBean.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return solb;
	}
	
	/**在数据库中移除订单中的该个菜品信息
	 * @author hcb
	 * 
	 */
	public int delOrderfood(String foodid) {
		// TODO Auto-generated method stub
		
		String sql1 = "select order_food_status from order_food where order_food_id=?";		//查询数据库中改id的
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

	/**催单的方法
	 * @author hcb
	 * 
	 */
	public int reminder(String tableid) {
		// TODO Auto-generated method stub
		//sql1 为查到该桌号下正在吃饭的订单编号
		//sql2为找到该订单当前的催单次数
		//sql3为更新当前需要更新订单催单次数
		String sql1 = "select ot.order_id from table_table tt,order_table ot where table_state=9 and ot.order_status=11 and ot.order_fk_tabid=tt.table_id and tt.table_id=?";
		String sql2 = "select order_press from order_food,order_table where fk_order_id=order_id and order_id=?";
		String sql3 = "update order_food set order_press=? where fk_order_id=?";
		int i = -1;
		try {
			Integer orderid = (Integer) qr.query(sql1, new ScalarHandler(1), tableid);	//查到该桌当前的订单编号
			orderid = orderid==null?0:orderid;
			Integer num = (Integer) qr.query(sql2, new ScalarHandler(1), orderid);		//查到当前订单的催单次数
			num = num==null?1:++num;
			Object[] params = new Object[]{num,orderid};
			i = DaoFactory.executeUpdate(sql3, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public Integer addOrderfood(String foodid, String tableid) {
		// TODO Auto-generated method stub
		//sql1为查询到该桌号下正在吃放的订单编号
		//sql2为向订单菜品表中插入新加菜的菜品记录
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
	
	
}
