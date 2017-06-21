package com.ordersystem.service;

import java.util.List;

import com.ordersystem.dao.impl.FoodDaoImpl;
import com.ordersystem.domain.DisheBean;
import com.ordersystem.domain.EmpBeam;

public class DisheService {
	FoodDaoImpl di=new FoodDaoImpl();
	public List<DisheBean> queryAllEmp() {
		List<DisheBean> allDish = di.QueryAllFood();
		return allDish;
	}
}
