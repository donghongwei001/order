package com.dong.action;

import java.util.ArrayList;

import com.daofactory.DaoFactory;

public class DongAction2 {
	public String save(){
		return "ok";
	}
	private String nameha;
	private String passha;
	
	

	public String getNameha() {
		return nameha;
	}



	public void setNameha(String nameha) {
		this.nameha = nameha;
	}



	public String getPassha() {
		return passha;
	}



	public void setPassha(String passha) {
		this.passha = passha;
	}



	public String dengluyanzheng(){
		
		System.out.println("1231212121212121212");
		try {
			Object[]params= new Object[]{getNameha()};
			ArrayList list=new DaoFactory().execQuery("select * from cus_table where cus_name=?", params);
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
