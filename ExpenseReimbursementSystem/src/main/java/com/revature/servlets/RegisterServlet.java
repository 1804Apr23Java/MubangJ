package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.exceptions.CreateEmployeeFailedException;
import com.revature.exceptions.EmployeeDoesNotExistException;
import com.revature.tables.User;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("register.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		//PrintWriter pw = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String fName = request.getParameter("firstname");
		String lName = request.getParameter("lastname");
		String email = request.getParameter("email");
		int isManager = Integer.parseInt(request.getParameter("isManager"));
		
		UserDao userDao = new UserDaoImpl();
		User user = null;
		try {
			
			userDao.insertUser(username, password, fName, lName, email, isManager);
			user = userDao.getUserByNameAndPass(username, password);
			
		} catch (CreateEmployeeFailedException | EmployeeDoesNotExistException e) {
			response.sendRedirect("error");
			session.setAttribute("problem", "incorrect password");
			response.sendRedirect("login");
			return;
		}
		
		session.setAttribute("username", user.getUsername());
		session.setAttribute("firstname", user.getfName());
		session.setAttribute("lastname", user.getLName());
		session.setAttribute("userId", user.getUserId());
		session.setAttribute("email",user.getEmail());
		session.setAttribute("isManager",user.getIsManager());
		session.setAttribute("problem", null);
		response.sendRedirect("profile");
		
	}

}
