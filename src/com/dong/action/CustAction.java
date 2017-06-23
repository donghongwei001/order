package com.dong.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.daofactory.DaoFactory;
import com.ordersystem.domain.CustBean;
import com.ordersystem.domain.CustBean_indent;
import com.ordersystem.service.CustService;

public class CustAction extends BaseAction{
	private CustBean_indent c;
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpServletResponse response=ServletActionContext.getResponse();
	CustService ce=new CustService();
	public String xiaofeixq(){
		String cus_id = super.getparameter("cus_id");
		List<CustBean_indent> li=ce.shop(cus_id);
		super.setRequestAttr("list", li);
		return "successs";
	}
	
	public void selectuser() {
		String user=request.getParameter("name");
		List<CustBean> cb = ce.showCust(user);
		super.setsession("list", cb);
		try {
			request.getRequestDispatcher("/admin/products/cust_list.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String showAllCust(){
		List<CustBean> cb = ce.showAllCust();
		super.setsession("list", cb);
		try { 
			request.getRequestDispatcher("/admin/products/cust_list.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
