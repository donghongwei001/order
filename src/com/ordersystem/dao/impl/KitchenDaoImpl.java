package com.ordersystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

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
	
	/* (non-Javadoc)
	 * @see com.ordersystem.dao.KitchenDao#showWaitFood()
	 */
	public List<SortKitchenFoodBean> showWaitFood() {
		// TODO Auto-generated method stub
		//Connection conn = cp.getConn();
		QueryRunner qr = new QueryRunner(cp.getBds());
		String sql = "";
		List<WaitFoodBean> wfb = null;  //-----wfb��ŵ������ݿⷵ�ص� waitfoodbean����
		try {
			wfb = qr.query(sql, new BeanListHandler<WaitFoodBean>(WaitFoodBean.class), "params");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (wfb.size()==0) {
			return null;
		}
		
		/**�Դ����ݿ�ȡ����ÿ����Ʒlist���Ͻ��� �������˷�װ
		 * @author hcb
		 * 
		 */
		List<SortKitchenFoodBean> list = new ArrayList<SortKitchenFoodBean>();	//������ŷ�װ��Ƥ�Ĳ�Ʒ�����
		for (int i = 0; i < wfb.size(); i++) {		
			
			//ʵ������Ʒ��װ��
			SortKitchenFoodBean skfb = new SortKitchenFoodBean();
			skfb.setWfb(wfb.get(i));
			
			//����Ȩ��,��Ȩ�����Ը�ֵ
			double weight = 0;	//����Ȩ�ر���
			weight = (0.3*wfb.get(i).getLasttime()+0.3*wfb.get(i).getTime()+0.4*wfb.get(i).getOrder_press()*100)*wfb.get(i).getFood_time();
			skfb.setWeight(weight);
			
			int num2 = wfb.get(i).getFood_num(); 		//���tab���ĸò˵�����
			skfb.setFoodnum(num2);
			
			//���� ��ѭ���鿴list���������Ƿ������ͬ�Ĳ�
			int flag = 0;	//����һ����־ �����ж��Ƿ񲢲���
			for (int j = 0; j < list.size(); j++) {
				//�ж� ����ò˵Ĳ����ͱ�ע��ζ��ͬ����Ժϲ��ò�
				//���Ƹò˵����ϲ���
				//���˺�����ʾ���Ŷ�Ӧ�ĸò�����
				if (wfb.get(i).getFood_name().equals(list.get(j).getWfb().getFood_name()) && wfb.get(i).getOrder_food_mark().equals(list.get(j).getWfb().getOrder_food_mark())) {
					
					int num = list.get(j).getFoodnum();		//���������ͬ��Ҫ���˵Ĳ�Ʒ ���õ�ǰ�Ѻϲ�������
					String tab = list.get(j).getWfb().getTable_name();	//�õ�֮ǰ�Ѵ��ڸò˵�����
					//�ж�list�е�������Ƿ��ǵ�һ�β���
					if (tab.contains(":")) {
						tab = tab+","+wfb.get(i).getTable_name()+":"+wfb.get(i).getFood_num();
					}else {
						tab = tab+":"+num+","+wfb.get(i).getTable_name()+":"+wfb.get(i).getFood_num();		//+","+
					}
					list.get(j).getWfb().setTable_name(tab);		//�����Ҫ���˰�������װ�õ�  ����:������  ���¸�ֵ��ԭ������������
					flag=1;		//���ı�־
					num2 += num;	
					list.get(j).setFoodnum(num2);		//�����Ҫ���� ����°�װ���еĲ�Ʒ����
				}
			}
			if(flag==0)
			list.add(skfb);
		}//���˽���
		
		/**���Ѿ���װ�õ�list���Ͻ��а�Ȩ������
		 * @author hcb
		 * 
		 */
		for (int j = 0; j < list.size()-1; j++) {
			for (int j2 = 1; j2 < list.size()-j; j2++) {
				if (list.get(j).getWeight()<list.get(j+1).getWeight()) {
					SortKitchenFoodBean temp = list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1, temp);
				}
			}
		}
		return list;
	}
}
