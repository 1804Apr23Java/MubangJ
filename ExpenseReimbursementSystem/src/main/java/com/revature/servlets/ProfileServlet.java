package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get the current Session or a null
		HttpSession session = req.getSession(false);
		//check whether a Session exists
		String username = (String) session.getAttribute("username");
		String email = (String) session.getAttribute("email");
		
		if (session != null && username != null) {
			req.setAttribute("username", username);
			req.setAttribute("email", email);

			req.getRequestDispatcher("profile.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("login");
		}
	}


}
