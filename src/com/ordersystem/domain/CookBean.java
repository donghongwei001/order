package com.ordersystem.domain;

public class CookBean {
	private int dishes_id;  //��ϵ���
	private String  dishes_name; //��ϵ��
	public int getDishes_id() {
		return dishes_id;
	}
	public void setDishes_id(int dishes_id) {
		this.dishes_id = dishes_id;
	}
	public String getDishes_name() {
		return dishes_name;
	}
	public void setDishes_name(String dishes_name) {
		this.dishes_name = dishes_name;
	}
	@Override
	public String toString() {
		return "CookBean [dishes_id=" + dishes_id + ", dishes_name="
				+ dishes_name + "]";
	}
	
}
