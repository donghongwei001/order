package com.dong.action;

import com.ordersystem.dao.impl.Userdaoimpl;
import com.ordersystem.domain.User;

public class dongAction {
	private User u;
	public String save(){
		new Userdaoimpl().save(u);
		return "ok";
	}
	public String update(){
		return "ok";
	}
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	
}
