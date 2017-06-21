package com.dong.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;

import com.ConnPool.NaturalPersonService;
import com.ConnPool.PageUtil;
import com.daofactory.Connpool;
import com.daofactory.DaoFactory;
import com.ordersystem.dao.impl.Userdaoimpl;
import com.ordersystem.domain.OrderBean;

public class DongAction3 {
	Connpool cp = new Connpool();
	HttpSession session=ServletActionContext.getRequest().getSession();
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpServletResponse response=ServletActionContext.getResponse();
	public String save(){
		return "ok";
	}
	
	public String update() throws IOException{
		
		String shijian1=request.getParameter("shijiankuang1");
		String shijian2=request.getParameter("shijiankuang2");
		
		Object[] objects=new Object[]{shijian1,shijian2};
		ArrayList list =new DaoFactory().execQuery("select count(*), sum(order_money) from order_table where order_time between ? and ?", objects);
		session.setAttribute("list1", list);
		return "error";
	}
	
	
	
	
	
	private NaturalPersonService personService=new NaturalPersonService();
	public String query1() throws IOException{
		/*String sql = "select o.order_id,o.order_time,o.order_fk_tabid,o.order_money,e.emp_name,c.cus_name,o.order_dt_score,o.oeder_dt_mark from order_table o,emp_table e,cus_table c where o.order_fk_empid=e.emp_id and o.order_fk_cusid=c.cus_id";
		//ArrayList tableList=new Userdaoimpl().executeQuery(sql);
		QueryRunner qr = new QueryRunner(cp.getDataSource());
		List<OrderBean> tableList = null;
		try {
			tableList = qr.query(sql, new BeanListHandler<OrderBean>(OrderBean.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("list1", tableList);
		ArrayList list1=new Userdaoimpl().executeQuery("select count(*) from order_table");
		
		session.setAttribute("count", list1);
		return "aaa";*/
		String currPageStr=request.getParameter("currPage");
		String pageSizeStr=request.getParameter("pageSize");
		Integer currPage=null;
		Integer pageSize=null;
		try {
			currPage=Integer.parseInt(currPageStr);
			pageSize=Integer.parseInt(pageSizeStr);
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		HttpSession session = request.getSession();
		PageUtil util=personService.select(currPage, pageSize);
		session.setAttribute("list", util);
		List list1=util.getRows();
		session.setAttribute("List1", list1);
		response.sendRedirect("/Ordersystem/admin/products/order_list.jsp");
		return null;
	}
	
}
