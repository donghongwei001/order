package com.dong.action;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
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
import com.ordersystem.domain.DisheBean;
import com.ordersystem.domain.GouwucheBean;
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
	
	//登录选桌
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
		return null;
	}
	
	//加载菜品
	@Action("findfood")
	public String findfood() throws IOException{
		
		QueryRunner qr = new QueryRunner(cp.getDataSource());
		List<DisheBean> list1=null;
		try {
			list1 = qr.query("select food_id, food_name,food_price,food_pic from food_table where food_fk_dishes_id=1 order by food_id asc", new BeanListHandler<DisheBean>(DisheBean.class));
			session.setAttribute("list1", list1);
			ArrayList list2=new Userdaoimpl().executeQuery("select count(*) from food_table where food_fk_dishes_id=1");
			session.setAttribute("list2", list2);
			response.sendRedirect("mainfood.jsp");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	//菜品详情
	@Action("foodintro")
	public String foodintro() throws IOException{
		String id=request.getParameter("id");
		QueryRunner qr = new QueryRunner(cp.getDataSource());
		List<DisheBean> tableList = null;
		try {

			tableList = qr.query("select food_id, food_name,food_price,food_pic,food_description from food_table where food_id =?", new BeanListHandler<DisheBean>(DisheBean.class),id);
		}catch (Exception e) {
			// TODO: handle exception
		}
		session.setAttribute("foodintro", tableList);
		response.sendRedirect("foodintro.jsp");
		return null;
	}
	
	
	private String index;
	private String name;
	private String price;
	
	public String getIndex() {
		return index;
	}


	public void setIndex(String index) {
		this.index = index;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}

	
	
	
	//
	@Action("xiadan")
	public String gouwuchegengxin(){
		String user=(String) session.getAttribute("user");
		String zhuahao=(String) session.getAttribute("zhuohao");
		String shijian=MyFormat.getDateformat().format(new Date());
		
		try {
		
		Integer money=(Integer) session.getAttribute("he");
		Object[]params=new Object[]{user};
		ArrayList<ArrayList> list=new DaoFactory().execQuery("select cus_id from cus_table where cus_name=?", params);
		Object[]params1=new Object[]{zhuahao};
		ArrayList<ArrayList> list1=new DaoFactory().execQuery("select fk_emp_id from ser_tab where fk_table_id=?", params1);
		Object[]params2=new Object[]{shijian,zhuahao,money,list1.get(0).get(0),shijian,list.get(0).get(0)};
		int flag=new DaoFactory().executeUpdate("insert into order_table(order_id,order_time,order_fk_tabid,order_money,order_fk_empid,order_lasttime,order_fk_cusid) values (15,?,?,?,?,?,?)", params2);
		System.out.println(flag);
		ArrayList list2=(ArrayList) session.getAttribute("cart");
		for (int i = 0; i < list2.size(); i++) {
			GouwucheBean gBean=(GouwucheBean) list2.get(i);
			Object[]params3=new Object[]{gBean.getId(),gBean.getCount()};
			int flag1=new DaoFactory().executeUpdate("insert into order_food(fk_order_id,fk_food_id,order_food_num,order_food_status) values(15,?,?,1)", params3);
			System.out.println(flag1);
		}
		Object[]params4=new Object[]{zhuahao};
		int flag2=new DaoFactory().executeUpdate("update table_table set table_state=9 where table_id=?", params4);
		System.out.println(flag2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}





