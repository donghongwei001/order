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
import com.ordersystem.domain.TableBean;
import com.ordersystem.service.TableService;


	
public class TableAction extends BaseAction{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		TableService ts=new TableService();
		public String selezhuo() {
			String table_id = super.getparameter("zhuohao");
			List<TableBean> li=ts.selezhuohao(table_id);
			super.setsession("list", li);
			System.out.println("11111");
			return "ss";
		}
		
		public String seleAll() { 
			List<TableBean> li=ts.seleA();
			super.setsession("list", li);
			try {
				request.getRequestDispatcher("/admin/products/table_list.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "ss";
		}
		
		public String addzhuozi() {
			String id=super.getparameter("name");
			String renshu=super.getparameter("pnum");
			String fuwuyuan=super.getparameter("fuwuyuan");
			String zhuangtai=super.getparameter("zhuangtai");
			
			return "ss";
		}
}
