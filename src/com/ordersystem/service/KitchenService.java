package com.ordersystem.service;

import java.util.List;

import com.ordersystem.dao.impl.KitchenDaoImpl;
import com.ordersystem.domain.FoodBean;
import com.ordersystem.domain.SortKitchenFoodBean;
import com.ordersystem.domain.WaitFoodBean;

public class KitchenService {
	KitchenDaoImpl kdi = new KitchenDaoImpl();
	
	public List<SortKitchenFoodBean> showWaitFood() {
		
		return kdi.showWaitFood();
	}
	
	/**��ѯ��ʾ�����Ĳ˵���ʾ�ں��ҳ����
	 * @author hcb
	 * 
	 */
	public List<WaitFoodBean> showAllfood() {
		// TODO Auto-generated method stub
		String sql = "";
		return null;
	}
}
