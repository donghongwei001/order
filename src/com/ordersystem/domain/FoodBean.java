package com.ordersystem.domain;

import java.io.Serializable;

public class FoodBean implements Serializable{
	private int food_id;
	private String food_name;
	private int food_price;
	private String dishes_name;
	private int food_time;
	public FoodBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FoodBean(int food_id, String food_name, int food_price,
			String dishes_name, int food_time) {
		super();
		this.food_id = food_id;
		this.food_name = food_name;
		this.food_price = food_price;
		this.dishes_name = dishes_name;
		this.food_time = food_time;
	}
	public int getFood_id() {
		return food_id;
	}
	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public int getFood_price() {
		return food_price;
	}
	public void setFood_price(int food_price) {
		this.food_price = food_price;
	}
	public String getDishes_name() {
		return dishes_name;
	}
	public void setDishes_name(String dishes_name) {
		this.dishes_name = dishes_name;
	}
	public int getFood_time() {
		return food_time;
	}
	public void setFood_time(int food_time) {
		this.food_time = food_time;
	}
	
}
