package com.order.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.inject.Context;
import com.ordersystem.domain.WaitFoodBean;
import com.ordersystem.service.KitchenService;

public class KitchenServlet extends HttpServlet {

	KitchenService ks = new KitchenService();
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String method = request.getParameter("method");
		if (method.equals("list")) {
			pageList(request, response);
		}else if (method.equals("makefood")) {
			
		}
	}
	
	/**显示后厨菜单列表的方法
	 * @author hcb
	 * @throws IOException 
	 * @throws ServletException 
	 * 
	 */
	private void pageList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<WaitFoodBean> foodList = ks.showAllfood();
		request.setAttribute("lsit", foodList);
		request.getRequestDispatcher("admin/products/Kitchen.jsp").forward(request, response);
	}


}
