package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewEmployees
 */
public class ViewEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewEmployees() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session != null && session.getAttribute("username") != null) {

			request.getRequestDispatcher("allEmployees.jsp").forward(request, response);
			
		} else {
			response.sendRedirect("login");
			
		}
	}

}
