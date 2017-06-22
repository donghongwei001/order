package com.dong.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.ConnPool.NaturalPersonService;
import com.ConnPool.PageUtil;
import com.alibaba.fastjson.JSON;
import com.daofactory.Connpool;
import com.daofactory.DaoFactory;
import com.opensymphony.xwork2.ActionSupport;
import com.ordersystem.dao.impl.Userdaoimpl;
import com.ordersystem.domain.OrderBean;
import com.ordersystem.domain.TableBean;
import com.ordersystem.entity.MyFormat;
import com.sun.org.apache.bcel.internal.generic.NEW;

@ParentPackage("struts-default")

public class dongAction4 extends ActionSupport{
	private String value;
	//private Dongchaxun dongchaxun;
	
	Connpool cp = new Connpool();
	/*HttpServletRequest request=ServletActionContext.getRequest();
	public String save() throws ParseException{
	String shijian1=request.getParameter("shijiankuang1");
	String shijian2=request.getParameter("shijiankuang2");

	Object[] objects=new Object[]{shijian1,shijian2};
	ArrayList list =new DaoFactory().execQuery("select COUNT(*), sum(order_money) from order_table where order_time between ? and ? ", objects);
	request.setAttribute("list", list);*/
	private NaturalPersonService personService=new NaturalPersonService();

	HttpServletRequest request=ServletActionContext.getRequest();	
	HttpServletResponse response=ServletActionContext.getResponse();
	HttpSession session=ServletActionContext.getRequest().getSession();
	
	
	//订单查询
	
	@Action("fenye")
	public String save() throws ServletException, IOException{
		                                
		String shijian2=MyFormat.getDateformat().format(new Date());
		String shijian=MyFormat.getDateFormata().format(new Date());
		String shijian1=shijian+" 00:00:00";
		
		System.out.println(shijian1);
		System.out.println(shijian2);
		Object[]params=new Object[]{shijian1,shijian2};
		ArrayList list=new DaoFactory().execQuery("select count(*) ,sum(order_money) from order_table where order_time between ? and ?", params);
		session.setAttribute("list", list);
		response.sendRedirect("/Ordersystem/admin/products/money_list.jsp");
		

		return null;
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

	//前台验证登录
	
	

	//前台注册
	@Action("zhuce")
	public String update(){
		System.out.println(getValue());
		HttpServletResponse response = ServletActionContext.getResponse(); 

		response.setContentType("text/html;charset=UTF-8"); 
		try {
			Object[]params =new Object[]{getValue()};
			ArrayList tableList=new DaoFactory().execQuery("select * from cus_table where cus_name=?",params);
			System.out.println(getValue());
			System.out.println(tableList.size());
			if (tableList.size()!=0) {
				String haha="ture";
				//String jsonstr=JSON.toJSONString(haha);
				response.getWriter().print(haha);
			}else {
				String haha="false";
				//String jsonstr=JSON.toJSONString(haha);
				response.getWriter().print(haha);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	/*public Dongchaxun getDongchaxun() {
		return dongchaxun;
	}





	public void setDongchaxun(Dongchaxun dongchaxun) {
		this.dongchaxun = dongchaxun;
	}*/


	

	//财务查询
	@Action("chaxun")
	public String query(){
		String shijian1=request.getParameter("shijiankuang1");
		String shijian2=request.getParameter("shijiankuang2");
		try {
			if (!shijian1.equals("")&&!shijian2.equals("")) {
				Object[] objects=new Object[]{shijian1,shijian2};
				ArrayList list =new DaoFactory().execQuery("select count(*), sum(order_money) from order_table where order_time between ? and ?", objects);
				session.setAttribute("list1", list);
				response.sendRedirect("/Ordersystem/admin/products/money_list.jsp");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;

	}


	



	//订单查询
	@Action(value = "dongdingdan", results = { @Result(name = "error", location = "/admin/products/order_list.jsp") })
	public String dingdan(){
		
		HttpServletRequest request=ServletActionContext.getRequest();
		String shijian3=request.getParameter("shijiankuang3");
		String shijian4=request.getParameter("shijiankuang4");
		String name=request.getParameter("ordername");
		if (name==""&&(shijian3!=""&&shijian4!="")) {
			String sql = "select order_id,order_time,order_fk_tabid,order_money,order_fk_empid,order_fk_cusid,order_dt_score,oeder_dt_mark from order_table where order_time >=? and order_time<=?";
			//ArrayList tableList=new Userdaoimpl().executeQuery(sql);
			QueryRunner qr = new QueryRunner(cp.getDataSource());
			List<OrderBean> tableList = null;
			try {

				tableList = qr.query(sql, new BeanListHandler<OrderBean>(OrderBean.class),shijian3,shijian4);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("List1", tableList);


		}
		if (name!=""&&(shijian3==""&&shijian4=="")) {//select order_id,order_time,order_fk_tabid,order_money,order_fk_empid,order_fk_cusid,order_dt_score,oeder_dt_mark from order_table where order_id=?
			String sql = "select order_id,order_time,order_fk_tabid,order_money,order_fk_empid,order_fk_cusid,order_dt_score,oeder_dt_mark from order_table where order_id=?";
			//ArrayList tableList=new Userdaoimpl().executeQuery(sql);
			QueryRunner qr = new QueryRunner(cp.getDataSource());
			List<OrderBean> tableList = null;
			try {

				tableList = qr.query(sql, new BeanListHandler<OrderBean>(OrderBean.class),name);
				

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			session.setAttribute("List1", tableList);

		}
		
		try {
			response.sendRedirect("/Ordersystem/admin/products/order_list.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//订单分页
	
	
	@Action("dengluyan")
	public String dengluyanzheng() throws IOException{
		
		int flag=0;
		ArrayList list=new Userdaoimpl().executeQuery("select *  from cus_table");
		for (int i = 0; i < list.size(); i++) {
			ArrayList list1=(ArrayList) list.get(i);
			if (list1.get(1).equals(getNameha())&&list1.get(2).equals(getPassha())) {
				flag=1;
			}
		}
		String str=null;
		if (flag==1) {
			QueryRunner qr = new QueryRunner(cp.getDataSource());
			List<TableBean> list1=null;
			try {
				list1 = qr.query("select table_id from table_table where table_state=8", new BeanListHandler<TableBean>(TableBean.class));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//ArrayList list1=new Userdaoimpl().executeQuery("select table_id from table_table where table_state=8");
			str=JSON.toJSONString(list1);
		}else if (flag==0) {
			str=JSON.toJSONString(flag);
		}
		response.getWriter().print(str);
		
		return null;
	}
	
	
	@Action("shanchu")
	public String shanchu(){
		String name=request.getParameter("id");
		
		System.out.println(name);
		/*Object[]params=new Object[]{count};
		try {
			int flag=DaoFactory.executeUpdate("delete order_table where order_id = ?", params);
			if (flag>0) {
				response.sendRedirect("/Ordersystem/fenye.action");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}*/
		
		
		
		return null;
	}
}





