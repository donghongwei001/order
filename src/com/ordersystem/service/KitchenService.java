package com.ordersystem.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.ordersystem.dao.impl.KitchenDaoImpl;
import com.ordersystem.domain.FoodCategoryBean;
import com.ordersystem.domain.SortKitchenFoodBean;
import com.ordersystem.domain.WaitFoodBean;
import com.ordersystem.entity.MyFormat;

public class KitchenService {
	KitchenDaoImpl kdi = new KitchenDaoImpl();
	
	/**��ѯ��ʾ�����Ĳ�Ʒ  ���Ұ�Ȩ������
	 * @author hcb
	 * 
	 */
	public List<SortKitchenFoodBean> showWaitFood(String foodStatus) {
		String sql = "select odf.order_food_id,odf.order_food_weight,ot.order_id 'fk_order_id',tt.table_id 'table_name' , ft.food_name 'food_name',odf.order_food_mark 'order_food_mark',DATEDIFF(minute,ot.order_lasttime,GETDATE()) 'lasttime',DATEDIFF(minute,ot.order_time,GETDATE()) 'time',et.emp_name 'emp_name',odf.order_press 'order_press',ft.food_time 'food_time',odf.order_food_num 'food_num',ft.food_merge 'food_maxcb' from order_food odf,order_table ot,emp_table et,food_table ft,table_table tt"+
				" where odf.fk_food_id = ft.food_id and odf.fk_order_id = ot.order_id  and ot.order_fk_empid = et.emp_id and ot.order_fk_tabid = tt.table_id and odf.order_food_status="+foodStatus+" and ot.order_status=11 order by order_food_weight desc";
		return kdi.showWaitFood(sql,sql);
		
	}
	
	
	/**�˷���������ѯ���������Ĳ�
	 * @author hcb
	 * 
	 */
	public List<WaitFoodBean> showDoneFood(Integer pagesize,Integer startIndex ) {
		// TODO Auto-generated method stub
		Timestamp dayBegin = MyFormat.getDayBegin();
		String nowtime = MyFormat.getDateformat().format(new Date());
		String sql = "select top "+pagesize+" odf.order_food_id,odf.order_food_weight,odf.servingtime,ot.order_id 'fk_order_id',tt.table_id 'table_name' , ft.food_name 'food_name',odf.order_food_mark 'order_food_mark',DATEDIFF(SS,ot.order_lasttime,GETDATE()) 'lasttime',DATEDIFF(SS,ot.order_time,GETDATE()) 'time',et.emp_name 'emp_name',odf.order_press 'order_press',ft.food_time 'food_time',odf.order_food_num 'food_num',ft.food_merge 'food_maxcb' from order_food odf,order_table ot,emp_table et,food_table ft,table_table tt"+
				" where odf.fk_food_id = ft.food_id and odf.fk_order_id = ot.order_id  and ot.order_fk_empid = et.emp_id and ot.order_fk_tabid = tt.table_id and odf.order_food_status=3 and odf.servingtime between '"+dayBegin+"' and '"+nowtime+"' and odf.servingtime not in(select top "+startIndex+" odf.servingtime from order_food odf,order_table ot,emp_table et,food_table ft,table_table tt "+
						"where odf.fk_food_id = ft.food_id and odf.fk_order_id = ot.order_id  and ot.order_fk_empid = et.emp_id and ot.order_fk_tabid = tt.table_id and odf.servingtime between '"+dayBegin+"' and '"+nowtime+"' and odf.order_food_status=3 order by odf.servingtime desc) order by servingtime desc";
		return kdi.showFood(sql);
	}

	/**��ѯ״̬Ϊ3 �Ĳ�Ʒ���� ӦΪsql��䲻ͬ ����Ҫ�ֿ� 
	 * @author hcb
	 * 
	 */
	public String findPageCountdone() {
		// TODO Auto-generated method stub
		Timestamp dayBegin = MyFormat.getDayBegin();
		String nowtime = MyFormat.getDateformat().format(new Date());
		String sql = "select count(*) from order_food odf,order_table ot,emp_table et,food_table ft,table_table tt where odf.fk_food_id = ft.food_id and odf.fk_order_id = ot.order_id  and ot.order_fk_empid = et.emp_id and ot.order_fk_tabid = tt.table_id and odf.order_food_status=3 and odf.servingtime between '"+dayBegin+"' and '"+nowtime+"'"; 
				/*"select odf.order_food_id,odf.order_food_weight,ot.order_id 'fk_order_id',tt.table_id 'table_name' , ft.food_name 'food_name',odf.order_food_mark 'order_food_mark',DATEDIFF(minute,ot.order_lasttime,GETDATE()) 'lasttime',DATEDIFF(minute,ot.order_time,GETDATE()) 'time',et.emp_name 'emp_name',odf.order_press 'order_press',ft.food_time 'food_time',odf.order_food_num 'food_num',ft.food_merge 'food_maxcb' from order_food odf,order_table ot,emp_table et,food_table ft,table_table tt"+
				" where odf.fk_food_id = ft.food_id and odf.fk_order_id = ot.order_id  and ot.order_fk_empid = et.emp_id and ot.order_fk_tabid = tt.table_id and odf.order_food_status="+status+" order by order_food_weight desc";*/
		return kdi.findCount(sql);
	}
	
	/**���ҳ��������Ĳ�Ʒ������(status Ϊ״̬ ������ʾ����,���ҳ������ѯ)	
	 * @author hcb
	 * 
	 */
	public String findCount(String status) {
		// TODO Auto-generated method stub
		String sql = "select COUNT(*) from order_food odf,order_table ot,emp_table et,food_table ft,table_table tt"+
				" where odf.fk_food_id = ft.food_id and odf.fk_order_id = ot.order_id  and ot.order_fk_empid = et.emp_id and ot.order_status=11 and ot.order_fk_tabid = tt.table_id and odf.order_food_status="+status;
		
		return kdi.findCount(sql);
	}
	
	/**�������ݿ��Ʒ״̬�ķ���
	 * @author hcb
	 * 
	 */
	public void updateStatus(String id,String status) {
		// TODO Auto-generated method stub
		String sql="update order_food set order_food_status=? where order_food_id in (?)";
		
		if (id.indexOf("-")>0) {
			String[] params = id.split("-");
			for (int i = 0; i < params.length; i++) {
				kdi.updateDataBase(sql,status,params[i]);
			}
		}else{
			kdi.updateDataBase(sql,status,id);
		}
	}
	
	/**�������ݿ��Ʒ״̬�ķ���
	 * @author hcb
	 * 
	 */
	public void updateStatusServingTime(String id,String status) {
		// TODO Auto-generated method stub
		String sql="update order_food set servingtime=? , order_food_status=? where order_food_id in (?)";
		String date = MyFormat.getLastServingFormat().format(new Date());
		if (id.indexOf("-")>0) {
			String[] params = id.split("-");
			for (int i = 0; i < params.length; i++) {
				kdi.updateDataBase(sql,date,status,params[i]);
			}
		}else{
			kdi.updateDataBase(sql,date,status,id);
		}
	}

	/**�������ݿ�����ϲ�ʱ��
	 * @author hcb
	 * 
	 */
	public void updateLastTime(String orderId) {
		// TODO Auto-generated method stub
		String sql="update order_table set order_lasttime=? where order_id in (?)";
		String date = MyFormat.getLastServingFormat().format(new Date());
		if (orderId.indexOf("-")>0) {
			String[] params = orderId.split("-");
			for (int i = 0; i < params.length; i++) {
				System.out.println(params[i]);
				kdi.updateDataBase(sql,date,params[i]);
			}
		}else{
			kdi.updateDataBase(sql,date,orderId);
		}
	}

	/**�㷨2:��ʱ���Ⱥ�����
	 * @author hcb
	 * 
	 */
	public List<SortKitchenFoodBean> secShowWaitFood(String foodStatus) {
		// TODO Auto-generated method stub
		String sql = "select odf.order_food_id,odf.order_food_weight,ot.order_id 'fk_order_id',tt.table_id 'table_name' , ft.food_name 'food_name',odf.order_food_mark 'order_food_mark',DATEDIFF(minute,ot.order_lasttime,GETDATE()) 'lasttime',DATEDIFF(minute,ot.order_time,GETDATE()) 'time',et.emp_name 'emp_name',odf.order_press 'order_press',ft.food_time 'food_time',odf.order_food_num 'food_num',ft.food_merge 'food_maxcb' from order_food odf,order_table ot,emp_table et,food_table ft,table_table tt"+
				" where odf.fk_food_id = ft.food_id and odf.fk_order_id = ot.order_id  and ot.order_fk_empid = et.emp_id and ot.order_fk_tabid = tt.table_id and odf.order_food_status="+foodStatus+" and ot.order_status=11 order by order_time asc";
		return kdi.secShowWaitFood(sql,sql);
	}

	/**�㷨3:������˳��ÿ��ȡһ�����ں��������ʾ
	 * @author hcb
	 * @Status Ϊ��Ҫ��ѯ��״̬eg:����,δ��
	 */
	public List<SortKitchenFoodBean> ThrShowWaitFood(String Status) {
		// TODO Auto-generated method stub
		List<SortKitchenFoodBean> foodlist = kdi.ThrShowWaitFood(Status);
		
		return foodlist;
	}

	/**��ѯ״̬Ϊ3 �Ĳ�Ʒ���� ӦΪsql��䲻ͬ ����Ҫ�ֿ� 
	 * @author hcb
	 * 
	 */
	public String findPageCount(String status) {
		// TODO Auto-generated method stub
		String sql ="select count(*) from order_food odf,order_table ot,emp_table et,food_table ft,table_table tt "+
					"where odf.fk_food_id = ft.food_id and odf.fk_order_id = ot.order_id  and ot.order_fk_empid = et.emp_id and ot.order_fk_tabid = tt.table_id and odf.order_food_status="+status;
				/*"select odf.order_food_id,odf.order_food_weight,ot.order_id 'fk_order_id',tt.table_id 'table_name' , ft.food_name 'food_name',odf.order_food_mark 'order_food_mark',DATEDIFF(minute,ot.order_lasttime,GETDATE()) 'lasttime',DATEDIFF(minute,ot.order_time,GETDATE()) 'time',et.emp_name 'emp_name',odf.order_press 'order_press',ft.food_time 'food_time',odf.order_food_num 'food_num',ft.food_merge 'food_maxcb' from order_food odf,order_table ot,emp_table et,food_table ft,table_table tt"+
				" where odf.fk_food_id = ft.food_id and odf.fk_order_id = ot.order_id  and ot.order_fk_empid = et.emp_id and ot.order_fk_tabid = tt.table_id and odf.order_food_status="+status+" order by order_food_weight desc";*/
		return kdi.findCount(sql);
	}

}
