package com.dong.interceptor;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.ordersystem.dao.impl.Userdaoimpl;

public class DongInterceptor3 extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request=ServletActionContext.getRequest();
		String user=request.getParameter("username");
		String pass=request.getParameter("password");
		ArrayList tableList=new Userdaoimpl().executeQuery("select account_number,account_psw from account");
		for (int i = 0; i < tableList.size(); i++) {
			ArrayList list=(ArrayList) tableList.get(i);
			if (user.equals(list.get(0))&&pass.equals(list.get(1))) {
				
					String resultp=arg0.invoke();
					return resultp;
			}
		}
		return "login";
	}
	
}
