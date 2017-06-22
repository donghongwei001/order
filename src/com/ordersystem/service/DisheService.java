package com.ordersystem.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ordersystem.dao.impl.DisheImpl;
import com.ordersystem.domain.DisheBean;
import com.ordersystem.domain.FoodCategoryBean;

public class DisheService {
	 DisheImpl di=new DisheImpl();
	
	 /**向数据库中插入菜品记录
	 * @author hcb
	 * 
	 */
	 public void addDishes(DisheBean db) {
		// TODO Auto-generated method stub
		di.addDishes(db);
	}

	public List<FoodCategoryBean> findCategory() {
		// TODO Auto-generated method stub
		List<FoodCategoryBean> fcb = di.findCategory();
		
		return fcb;
	}

	public List queryDishe(Map<String, String> ma,Map<String, String> price, String pageSize, String pageStart) {
		// TODO Auto-generated method stub
		String sta = "";
		if(ma.size()!=0){
			Set<String> key = ma.keySet();
			for (String k : key) {
				sta += " and "+k+" like '%"+ma.get(k)+"%'";
			}
		}
		if(price.size()!=0){
			sta +=" and ft.food_price between "+price.get("minprice")+" and "+price.get("maxprice");
		}
		String sql1 = "select top "+pageSize+" ft.food_id,ft.food_name,ft.food_price,ft.food_time,ft.food_merge,ft.food_pic,ft.food_fk_dishes_id,ft.food_description,dt.dishes_name from food_table ft,dishes_table dt where ft.food_fk_dishes_id=dt.dishes_id "+
		sta+" and ft.food_id not in(select top "+pageStart+" ft.food_id from food_table ft,dishes_table dt where ft.food_fk_dishes_id=dt.dishes_id "+sta+" order by ft.food_id asc) order by ft.food_id asc";
		String sql2 = "select count(*) from food_table ft,dishes_table dt where ft.food_fk_dishes_id=dt.dishes_id "+sta;
		List dishInfo = di.queryDishe(sql1,sql2);
		return dishInfo;
	}
}
