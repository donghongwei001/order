package com.ordersystem.service;

import java.util.List;

import com.ordersystem.dao.impl.KitchenDaoImpl;
import com.ordersystem.domain.SortKitchenFoodBean;

public class KitchenService {
	KitchenDaoImpl kdi = new KitchenDaoImpl();
	public List<SortKitchenFoodBean> showWaitFood() {
		
		return kdi.showWaitFood();
	}
}
