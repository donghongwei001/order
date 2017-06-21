package com.dong.action;

public class webAction extends BaseAction{
	public String excuted(){
		String user=super.getparameter("user");
		String pass=super.getparameter("pass");
		if (user.equals("admin")&&pass.equals("123456")) {
			return "ok";
		}else {
			return "error";
		}
	}
}
