package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
//		req.getRequestDispatcher("base.html").include(req, resp);
//		req.getRequestDispatcher("login.jsp").include(req, resp);

		HttpSession session = req.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		
		req.getRequestDispatcher("login").forward(req, resp);
	}

}
