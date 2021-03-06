package com.dong.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;


import com.alibaba.fastjson.JSON;
import com.daofactory.Connpool;
import com.daofactory.DaoFactory;
import com.ordersystem.dao.impl.Userdaoimpl;
import com.ordersystem.domain.DisheBean;
import com.ordersystem.domain.GouwucheBean;
import com.ordersystem.domain.OrderBean;
import com.ordersystem.domain.TableBean;

public class DongAction3 {
	Connpool cp = new Connpool();
	QueryRunner qr = new QueryRunner(cp.getDataSource());
	HttpSession session=ServletActionContext.getRequest().getSession();
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpServletResponse response=ServletActionContext.getResponse();
	public String save(){
		String user=request.getParameter("username");
		List<Object> query = null;
		try {
			query = qr.query("select right_url from account a,emp_table e,role_right r,right_table o where a.account_fk_emp_id=e.emp_id and e.emp_fk_pos_id=r.role_right_roleid and r.role_right_rightid=o.right_id and a.account_status=15 and a.account_number='"+user+"'", new ColumnListHandler(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("quanxian", query);
		session.setAttribute("user", user);
		System.out.println(session.getAttribute("quanxian"));
		return "ok";
	}
	private String user;
	private String pass;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	//后台登录
	public String houtaidenglu() throws IOException{
		ArrayList list=new Userdaoimpl().executeQuery("select account_number,account_psw from account");
		int flag=0;
		for (int i = 0; i < list.size(); i++) {
			ArrayList list1=(ArrayList) list.get(i);
			if (list1.get(0).equals(getUser())&&list1.get(1).equals(getPass())) {
				flag=1;
			}
		}
		String str=JSON.toJSONString(flag);
		response.getWriter().print(str);
		return null;
	}
	//财务时间搜索
	public String update() throws IOException{

		String shijian1=request.getParameter("shijiankuang1");
		String shijian2=request.getParameter("shijiankuang2");

		Object[] objects=new Object[]{shijian1,shijian2};
		ArrayList list =new DaoFactory().execQuery("select count(*), sum(order_money) from order_table where order_time between ? and ?", objects);
		session.setAttribute("list1", list);
		return "error";
	}




	//订单分页
	public String query1() throws IOException{

		String sql="select o.order_id,o.order_time,o.order_fk_tabid,o.order_money,e.emp_name,o.order_dt_score,o.oeder_dt_mark,t.code_name from code_table t, order_table o,emp_table e where t.code_id=o.order_status and o.order_fk_empid=e.emp_id  order by order_id desc";
		List<OrderBean> query;
		try {
			query = qr.query(sql,new BeanListHandler<OrderBean>(OrderBean.class));
			session.setAttribute("List1", query);
			System.out.println(query.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("/Ordersystem/admin/products/order_list.jsp");
		return null;

	}
	//购物车
	public String addshopcars() throws IOException, ServletException{


		String id=request.getParameter("id");
		String count=request.getParameter("count");
		String price=request.getParameter("price");
		int index=Integer.parseInt(count);
		int num=Integer.parseInt(price);
		int sum=index*num;
		Integer id1=Integer.parseInt(id);
		String sum1=Integer.toString(sum);
		Integer he=(Integer) session.getAttribute("he");
		if (he==null) {
			he=sum;
			session.setAttribute("he", he);
		}else {
			he=he+sum;
			session.setAttribute("he", he);
		}

		Object[]params=new Object[]{id};
		ArrayList list=new DaoFactory().execQuery("select food_name from food_table where food_id=?", params);

		GouwucheBean gBean=new GouwucheBean();
		gBean.setId(id1);
		gBean.setName(list);
		gBean.setCount(count);
		gBean.setPrice(sum1);
		ArrayList list2=new ArrayList();
		list2.add(gBean);
		/*session.setAttribute("cart", list2);
		System.out.println(list2);*/
		ArrayList list1= (ArrayList) session.getAttribute("cart");
		if (list1==null) {
			session.setAttribute("cart", list2);
		}else{
			list1.add(gBean);
			session.setAttribute("cart", list1);
		}
		return "cart";

	}


}
