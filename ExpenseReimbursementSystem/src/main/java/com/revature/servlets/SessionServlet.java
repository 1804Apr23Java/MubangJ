package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.tables.User;


/**
 * Servlet implementation class SessionServlet
 */
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session!=null) {
			response.setContentType("application/json");
			
			
			String username = (String) session.getAttribute("username");
			String firstName = (String) session.getAttribute("firstname");
			String lastName = (String) session.getAttribute("lastname");
			int userId = (int) session.getAttribute("userId");
			String email = (String) session.getAttribute("email");
			int managerId = (int) session.getAttribute("managerId");
			int isManager = (int) session.getAttribute("isManager");
			
			User user = new User(userId, username, null, firstName, lastName, email, managerId, isManager);
			
			ObjectMapper om = new ObjectMapper();
			String userString = om.writeValueAsString(user);
			response.getWriter().write("{\"user\":"+userString+"}");
			
//			response.getWriter().write("{\"username\":\""+username+"\"}");
			
		} else {
			response.setContentType("application/json");
			response.getWriter().write("{\"username\":null}");
		}
	}


}
