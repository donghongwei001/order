package com.ordersystem.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.daofactory.DaoFactory;
import com.ordersystem.dao.FoodDao;
import com.ordersystem.domain.FoodBean;

public class FoodDaoImpl implements FoodDao {

	public int addFood(FoodBean fo) {
		
		String sql2 = "select * from dishes_table where dishes_name=?";
		Object[] params2 = new Object[]{fo.getDishes_name()};
		ArrayList<ArrayList> list = DaoFactory.execQuery(sql2, params2);
		int id = (Integer) list.get(0).get(0);
		String sql = "insert into food_table values(?,?,?,?,?)";
		Object[] params = new Object[]{fo.getFood_id(),fo.getFood_name(),fo.getFood_price(),id,fo.getFood_time()};
		int flag = DaoFactory.executeUpdate(sql, params);
		return flag;
	}

	

	public List QueryAllFood() {
		// TODO Auto-generated method stub
		String sql = "select ft.food_name,dt.dishes_name,ft.food_price,ft.food_time from food_table ft,dishes_table dt where ft.food_fk_dishes_id=dishes_id";
		ArrayList<ArrayList> list = DaoFactory.execQuery(sql, null);
		return list;
	}

	public List QueryFoodById(int id) {
		// TODO Auto-generated method stub
		String sql = "select ft.food_name,dt.dishes_name,ft.food_price,ft.food_time from food_table ft,dishes_table dt where ft.food_fk_dishes_id=dishes_id and ft.food_id=?";
		Object[] params = new Object[]{id};
		ArrayList<ArrayList> list = DaoFactory.execQuery(sql, params);
		return list;
	}



	public List QueryFoodByName(String name) {
		// TODO Auto-generated method stub
		String sql = "select ft.food_name,dt.dishes_name,ft.food_price,ft.food_time from food_table ft,dishes_table dt where ft.food_fk_dishes_id=dishes_id and ft.food_name=%?%";
		Object[] params = new Object[]{name};
		ArrayList<ArrayList> list = DaoFactory.execQuery(sql, params);
		return list;
	}

}
