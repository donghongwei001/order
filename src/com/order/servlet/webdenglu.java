package com.order.servlet;
<<<<<<< HEAD

=======
asdffadf
>>>>>>> 2eec60056abc161d42035b376d75f6ad0d78f0dc
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class webdenglu extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if (username.equals("admin") && password.equals("123456")) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			response.sendRedirect("login.jsp");
		}
	}

}
