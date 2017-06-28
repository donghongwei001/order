package com.ordersystem.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.daofactory.Connpool;
import com.ordersystem.dao.KitchenDao;
import com.ordersystem.domain.SortKitchenFoodBean;
import com.ordersystem.domain.WaitFoodBean;

public class KitchenDaoImpl implements KitchenDao {

	public List<SortKitchenFoodBean> showWaitFood() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private static Connpool cp = new Connpool();
	private static QueryRunner qr = new QueryRunner(cp.getDataSource());
	
	/** �㷨1:�ۺ�����
	 * @see com.ordersystem.dao.KitchenDao#showWaitFood()
	 */
	public List<SortKitchenFoodBean> showWaitFood(String sql1,String sql2) {
		// TODO Auto-generated method stub
		setDbweight(sql2); //����ǰ�������ݿ������ú�Ȩ��
		return mergeFood(sql2);	//���ò��˺���
		}
	
	/**�㷨2:��ʱ��˳������
	 * @author hcb
	 * sql1
	 */
	public List<SortKitchenFoodBean> secShowWaitFood(String sql1,String sql2) {
		setSecDbweight(sql2);		//���°�ʱ���Ⱥ�˳������
		return mergeFood(sql2);		//���ò��˺���
	}
	
	/**�㷨2:�����Ƚ��ȳ��Ĳ�Ʒ����Ȩ��
	 * @author hcb
	 * 
	 */
	private void setSecDbweight(String sql) {
		// TODO Auto-generated method stub
		List<WaitFoodBean> wfb = showFood(sql);
		if (wfb.size()==0) {
			return;
		}
		//�Դ����ݿ�ȡ����ÿ����Ʒlist���Ͻ��� �����������ݿ������øò˵�Ȩ��
		for (int i = 0; i < wfb.size(); i++) {
			//System.out.println(wfb.get(i));
			double weight = 0;	//����Ȩ�ر���
			weight = 30*wfb.get(i).getTime()+45*wfb.get(i).getOrder_press();//30��45  ÿ���Ӽ�Ȩ��30 û��һ�β�Ȩ�ؼ�45 �൱�ڰ���һ�β�����ǰ��ǰ1.5����
			//System.out.println(weight);
			
			String upsql = "update order_food set order_food_weight=? where order_food_id=?";
			try {
				qr.update(upsql, weight,wfb.get(i).getOrder_food_id());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
	}

	/**�ϲ���Ʒ�ĺ���
	 * @author hcb
	 * 
	 */
	private List<SortKitchenFoodBean> mergeFood(String sql2) {
		// TODO Auto-generated method stub
		List<WaitFoodBean> wfb = showFood(sql2);	//��Ȩ����������ݿ��в������
		List<SortKitchenFoodBean> MergeList = megerFood(wfb);
		return MergeList;
	}
	
	/**���ϲ��˵ĺ���
	 * @author hcb
	 * @wfb Ϊ���ݿ�ȡ���Ĳ�Ʒ����
	 */
	private List<SortKitchenFoodBean> megerFood(List<WaitFoodBean> wfb) {
		if (wfb.size()==0) {
			return null;
		}
		List<SortKitchenFoodBean> MergeList = new ArrayList<SortKitchenFoodBean>();
		if(MergeList.size()<15){
			for (int i = 0; i < wfb.size(); i++) {
				SortKitchenFoodBean skfb = new SortKitchenFoodBean();	//��Ʒ��װ��
				int flag=-1;	//����һ����־ �ж��Ƿ�ϲ��˸ò�
				int fNum = wfb.get(i).getFood_num();		//��øò����������
				String tNum = wfb.get(i).getTable_name();	//��øò˵�����
				String idString = wfb.get(i).getOrder_food_id()+"";		//��Ʒid
				String food_name = wfb.get(i).getFood_name();		//��Ʒ����
				String orderId = wfb.get(i).getFk_order_id();		//����id  (��¼�������¶�������ϲ�ʱ��)
				//System.out.println(food_name);
				String order_food_mark = wfb.get(i).getOrder_food_mark();
				int maxMerge = wfb.get(i).getFood_maxcb();		//�õ��ò˵�����ܺϲ���
				String mark = wfb.get(i).getOrder_food_mark()==null?"ept":wfb.get(i).getOrder_food_mark();
				//����뼯��ǰ����for��mergelist���б���  �ж��Ƿ��ܽ��кϲ�
				for (int j = 0; j < MergeList.size(); j++) {
					//�����޸ĺϲ�����ʾ��Ʒ��Ŀ
					String foodnum = MergeList.get(j).getFoodnum();
					int megerNum = 0;	//����һ���ϲ���Ĳ�Ʒ����
					if (foodnum.indexOf('-')>0) {
						String[] splitfNum = foodnum.split("-");		//�Ȳ��ƴװ�õ��ַ���
						for (int k = 0; k < splitfNum.length; k++) {
							megerNum += Integer.parseInt(splitfNum[k]);	//ת��Ϊ���ֺ���Ӽ�Ϊ��ǰ���Ѻϲ�����
						}
					}else megerNum = Integer.parseInt(foodnum);			//���ȡ�����ַ��� ��ǰû�кϲ�����ֱ��ת��Ϊ���ָ�ʽ
					
					int count =fNum + megerNum;//֮ǰ�ϲ�������		//�������ϲ���ò˵�����  �ж�������С�����ϲ��� ����ϲ�������
					String merkM = MergeList.get(j).getWfb().getOrder_food_mark()==null?"ept":MergeList.get(j).getWfb().getOrder_food_mark();	//��ȡ��ע�����жϱ�ע�Ƿ�һ��
					if (food_name.equals(MergeList.get(j).getWfb().getFood_name()) && maxMerge >= count && mark.equals(merkM)) {
					//if (food_name.equals(MergeList.get(j).getWfb().getFood_name())&&order_food_mark.equals(MergeList.get(j).getWfb().getOrder_food_mark())&&maxMerge > MergeList.get(j).getFoodnum()) {
						flag = 1;
						String megerNumStr= MergeList.get(j).getFoodnum()+"-"+fNum;
						tNum = MergeList.get(j).getTabid()+","+tNum;//��������
						idString = MergeList.get(j).getOrder_food_id()+"-"+idString;//����id���
						orderId = MergeList.get(j).getOrderId()+"-"+orderId;	//���¶���id
						MergeList.get(j).setFoodnum(megerNumStr);			//���²�Ʒ��Ŀ
						MergeList.get(j).setOrder_food_id(idString);
						MergeList.get(j).setTabid(tNum);
						MergeList.get(j).setOrderId(orderId);
					}
				}
				skfb.setFoodnum(fNum+"");
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

	/**�㷨1:�������ݿ��е�Ȩ���ֶ�
	 * @author hcb
	 * 
	 */
	private void setDbweight(String sql) {
		List<WaitFoodBean> wfb = showFood(sql);
		if (wfb.size()==0) {
			return ;
		}
		//�Դ����ݿ�ȡ����ÿ����Ʒlist���Ͻ��� �������˷�װ
		List<SortKitchenFoodBean> list = new ArrayList<SortKitchenFoodBean>();	//������ŷ�װ�Ĳ�Ʒ�����
		for (int i = 0; i < wfb.size(); i++) {
			double weight = 0;	//����Ȩ�ر���
			weight = (0.15*wfb.get(i).getLasttime()+0.35*wfb.get(i).getTime()+0.5*wfb.get(i).getOrder_press()*50)*wfb.get(i).getFood_time();
			QueryRunner qr = new QueryRunner(cp.getDataSource());
			String upsql = "update order_food set order_food_weight=? where order_food_id=?";
			try {
				System.out.println(qr.update(upsql, weight,wfb.get(i).getOrder_food_id()));
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
		
		QueryRunner qr = new QueryRunner(cp.getDataSource());
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
			
	
	/**��ѯ���ݿ���ͳ�����ݵķ���������ͳ�ƵĽ��(count(*))
	 * @author hcb
	 * 
	 */
		public String findCount(String sql) {
			// TODO Auto-generated method stub
			QueryRunner qr = new QueryRunner(cp.getDataSource());
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
		QueryRunner qr = new QueryRunner(cp.getDataSource());
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
		QueryRunner qr = new QueryRunner(cp.getDataSource());
		try {
			qr.update(sql, param1,param2,param3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**�㷨3:������˳������ȡÿ�������еĲ�Ʒ���кϲ�
	 * @author hcb
	 * 
	 */
	public  List<SortKitchenFoodBean> ThrShowWaitFood(String status) {
		// TODO Auto-generated method stub
		//sql1Ϊ�����ݿ��в�ѯ��δ����(��Ҫ��������Ķ������)
		String sql1 = "select order_id from order_table where order_status=11 order by order_time asc";
		//sql2Ϊ�����ݿ��в��ҳ�ָ��������ŵĶ�����Ʒ����
		String sql2 = "select odf.order_food_id,odf.order_food_weight,ot.order_id 'fk_order_id',tt.table_id 'table_name' , ft.food_name 'food_name',odf.order_food_mark 'order_food_mark',DATEDIFF(minute,ot.order_lasttime,GETDATE()) 'lasttime',DATEDIFF(minute,ot.order_time,GETDATE()) 'time',et.emp_name 'emp_name',odf.order_press 'order_press',ft.food_time 'food_time',odf.order_food_num 'food_num',ft.food_merge 'food_maxcb' from order_food odf,order_table ot,emp_table et,food_table ft,table_table tt"+
				" where odf.fk_food_id = ft.food_id and odf.fk_order_id = ot.order_id  and ot.order_fk_empid = et.emp_id and ot.order_fk_tabid = tt.table_id and odf.order_food_status="+status+" and ot.order_status=11 and ot.order_id=? order by order_time asc";
		List<Object> orderId = null;
		List<List> allOrder = new ArrayList<List>();	//������װ���ж��� �� ÿ����Ʒ�ļ���
		List<WaitFoodBean> allfood = new ArrayList<WaitFoodBean>();	//������װ�����ĺ���Ĳ�Ʒ����
		try {
			orderId = qr.query(sql1, new ColumnListHandler());
			if (orderId==null) {
				return null;
			}
			for (Object object : orderId) {
				List<WaitFoodBean> oneorder  = qr.query("select odf.order_food_id,odf.order_food_weight,ot.order_id 'fk_order_id',tt.table_id 'table_name' , ft.food_name 'food_name',odf.order_food_mark 'order_food_mark',DATEDIFF(minute,ot.order_lasttime,GETDATE()) 'lasttime',DATEDIFF(minute,ot.order_time,GETDATE()) 'time',et.emp_name 'emp_name',odf.order_press 'order_press',ft.food_time 'food_time',odf.order_food_num 'food_num',ft.food_merge 'food_maxcb' from order_food odf,order_table ot,emp_table et,food_table ft,table_table tt where odf.fk_food_id = ft.food_id and odf.fk_order_id = ot.order_id  and ot.order_fk_empid = et.emp_id and ot.order_fk_tabid = tt.table_id and odf.order_food_status="+status+" and ot.order_status=11 and ot.order_id="+object+" order by order_time asc", new BeanListHandler<WaitFoodBean>(WaitFoodBean.class));
				allOrder.add(oneorder);
			}
			int j=-1;
			while(allOrder.size()>0){
				j++;
				for (int i = 0; i < allOrder.size(); i++) {
					if (allOrder.get(i)==null||allOrder.get(i).size()==j) {
						allOrder.remove(i);
						i--;
						continue;
					}
					allfood.add((WaitFoodBean) allOrder.get(i).get(j));
				}
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<SortKitchenFoodBean> list = megerFood(allfood);
		return list;
	}
	
	
}
