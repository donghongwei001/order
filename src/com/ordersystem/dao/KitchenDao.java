package com.ordersystem.dao;

import java.util.List;

import com.ordersystem.domain.SortKitchenFoodBean;

public interface KitchenDao {
	public List<SortKitchenFoodBean> showWaitFood();
}
