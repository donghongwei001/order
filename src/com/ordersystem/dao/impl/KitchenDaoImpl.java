package com.ordersystem.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.daofactory.Connpool;
import com.ordersystem.dao.KitchenDao;
import com.ordersystem.domain.SortKitchenFoodBean;
import com.ordersystem.domain.WaitFoodBean;

public class KitchenDaoImpl implements KitchenDao {
	
	/**�����ݿ��еõ����д�����Ʒ
	 * @author hcb
	 * 
	 */
	Connpool cp = new Connpool();
	
	/** (non-Javadoc)sql1��
	 * @see com.ordersystem.dao.KitchenDao#showWaitFood()
	 */
	public List<SortKitchenFoodBean> showWaitFood(String sql1,String sql2) {
		// TODO Auto-generated method stub
		setDbweight(sql2); //����ǰ�������ݿ������ú�Ȩ��
		return mergeFood(sql2);	//���ò��˺���
		}
	
	//���˵ĺ���
	private List<SortKitchenFoodBean> mergeFood(String sql2) {
		// TODO Auto-generated method stub
		List<WaitFoodBean> wfb = showFood(sql2);	//��Ȩ����������ݿ��в������
		if (wfb.size()==0) {
			return null;
		}
		List<SortKitchenFoodBean> MergeList = new ArrayList<SortKitchenFoodBean>();
		if(MergeList.size()<15){
			for (int i = 0; i < wfb.size(); i++) {
				SortKitchenFoodBean skfb = new SortKitchenFoodBean();	//��Ʒ��װ��
				int flag=-1;	//����һ����־ �ж��Ƿ�ϲ��˸ò�
				int fNum = wfb.get(i).getFood_num();
				String tNum = wfb.get(i).getTable_name();	//��øò˵�����
				String idString = wfb.get(i).getOrder_food_id()+"";		//��Ʒid
				String food_name = wfb.get(i).getFood_name();		//��Ʒ����
				String orderId = wfb.get(i).getFk_order_id();		//����id  (��¼�������¶�������ϲ�ʱ��)
				//System.out.println(food_name);
				String order_food_mark = wfb.get(i).getOrder_food_mark();
				int maxMerge = wfb.get(i).getFood_maxcb();
				//����뼯��ǰ����for��mergelist���б���  �ж��Ƿ��ܽ��кϲ�
				for (int j = 0; j < MergeList.size(); j++) {
					if (food_name.equals(MergeList.get(j).getWfb().getFood_name())) {
					//if (food_name.equals(MergeList.get(j).getWfb().getFood_name())&&order_food_mark.equals(MergeList.get(j).getWfb().getOrder_food_mark())&&maxMerge > MergeList.get(j).getFoodnum()) {
						System.out.println("���ϲ�������");
						flag = 1;
						fNum += MergeList.get(j).getFoodnum();	//��������
						tNum = MergeList.get(j).getTabid()+","+tNum;//��������
						idString = MergeList.get(j).getOrder_food_id()+"-"+idString;//����id���
						orderId = MergeList.get(j).getOrderId()+"-"+orderId;	//���¶���id
						System.out.println("�ϲ���Ķ��������:"+orderId);
						MergeList.get(j).setFoodnum(fNum);
						MergeList.get(j).setOrder_food_id(idString);
						MergeList.get(j).setTabid(tNum);
						MergeList.get(j).setOrderId(orderId);
					}
				}
				skfb.setFoodnum(fNum);
				skfb.setWfb(wfb.get(i));
				skfb.setOrder_food_id(idString);
				skfb.setTabid(tNum);
				skfb.setOrderId(orderId);
				if (flag==1) {
					System.out.println();
					continue;
				}
				MergeList.add(skfb);
			}
	}
		return MergeList;
	}

	/**�������ݿ��е�Ȩ���ֶ�
	 * @author hcb
	 * 
	 */
	private void setDbweight(String sql) {
		List<WaitFoodBean> wfb = showFood(sql);
		if (wfb.size()==0) {
			return ;
		}
		//System.out.println("---KitchenDaoImpl-------"+wfb.size());
		 
		//�Դ����ݿ�ȡ����ÿ����Ʒlist���Ͻ��� �������˷�װ
		List<SortKitchenFoodBean> list = new ArrayList<SortKitchenFoodBean>();	//������ŷ�װ�Ĳ�Ʒ�����
		for (int i = 0; i < wfb.size(); i++) {
			//System.out.println(wfb.get(i));
			double weight = 0;	//����Ȩ�ر���
			weight = (0.3*wfb.get(i).getLasttime()+0.3*wfb.get(i).getTime()+0.4*wfb.get(i).getOrder_press()*100)*wfb.get(i).getFood_time();
			//System.out.println(weight);
			QueryRunner qr = new QueryRunner(cp.getBds());
			String upsql = "update order_food set order_food_weight=? where order_food_id=?";
			try {
				qr.update(upsql, weight,wfb.get(i).getOrder_food_id());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
	}
		
	/**ͨ����дsql��������ݿ��в��Ҳ�Ʒ �������ݷ�װ��WaitFoodBean����  �ҷ���list����
	 * @author hcb
	 * 
	 */
	public List<WaitFoodBean> showFood(String sql) {
		
		QueryRunner qr = new QueryRunner(cp.getBds());
		List<WaitFoodBean> wfb = null;  //-----wfb��ŵ������ݿⷵ�ص� waitfoodbean����
		try {
			wfb = qr.query(sql, new BeanListHandler<WaitFoodBean>(WaitFoodBean.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return wfb;
	}
			
	public static void main(String[] args) {
		KitchenDaoImpl kdi = new KitchenDaoImpl();
		String sql1 ="select odf.order_food_id,odf.order_food_weight,ot.order_id 'fk_order_id',tt.table_id 'table_name' , ft.food_name 'food_name',odf.order_food_mark 'order_food_mark',DATEDIFF(SS,ot.order_lasttime,GETDATE()) 'lasttime',DATEDIFF(SS,ot.order_time,GETDATE()) 'time',et.emp_name 'emp_name',odf.order_press 'order_press',ft.food_time 'food_time',odf.order_food_num 'food_num',ft.food_merge 'food_maxcb' from order_food odf,order_table ot,emp_table et,food_table ft,table_table tt"+
				" where odf.fk_food_id = ft.food_id and odf.fk_order_id = ot.order_id  and ot.order_fk_empid = et.emp_id and ot.order_fk_tabid = tt.table_id";
		String sql2 ="select odf.order_food_id,odf.order_food_weight,ot.order_id 'fk_order_id',tt.table_id 'table_name' , ft.food_name 'food_name',odf.order_food_mark 'order_food_mark',DATEDIFF(SS,ot.order_lasttime,GETDATE()) 'lasttime',DATEDIFF(SS,ot.order_time,GETDATE()) 'time',et.emp_name 'emp_name',odf.order_press 'order_press',ft.food_time 'food_time',odf.order_food_num 'food_num',ft.food_merge 'food_maxcb' from order_food odf,order_table ot,emp_table et,food_table ft,table_table tt"+
				" where odf.fk_food_id = ft.food_id and odf.fk_order_id = ot.order_id  and ot.order_fk_empid = et.emp_id and ot.order_fk_tabid = tt.table_id order by order_food_weight desc";
		List<SortKitchenFoodBean> list = kdi.showWaitFood(sql1,sql2);
		//ArrayList<ArrayList> list2 = DaoFactory.execQuery(sql, null);
		for (int i = 0; i < list.size(); i++) {
			
			System.out.println(list.get(i));
		}
	}
	/**��ѯ���ݿ���ͳ�����ݵķ���������ͳ�ƵĽ��(count(*))
	 * @author hcb
	 * 
	 */
		public String findCount(String sql) {
			// TODO Auto-generated method stub
			QueryRunner qr = new QueryRunner(cp.getBds());
			String query = null;
			try {
				query = qr.query(sql, new ScalarHandler(1) ).toString();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return query;
		}
		
	/**�������ݿ�ķ���(һ�θ���һ�������ķ���)
	 * param1Ϊ��Ҫ���µĲ���
	 * param2λwhere���������
	 * @author hcb
	 * 
	 */
	public void updateDataBase(String sql, String param1, String param2) {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(cp.getBds());
		try {
			qr.update(sql, param1,param2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**�������ݿ�ķ���(һ�θ������������ķ���)
	 * param1Ϊ��Ҫ���µĲ���
	 * param2λwhere���������
	 * @author hcb
	 * 
	 */
	public void updateDataBase(String sql, String param1, String param2,String param3) {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(cp.getBds());
		try {
			qr.update(sql, param1,param2,param3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
