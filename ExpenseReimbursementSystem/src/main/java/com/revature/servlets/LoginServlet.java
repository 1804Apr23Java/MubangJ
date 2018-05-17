package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.exceptions.EmployeeDoesNotExistException;
import com.revature.tables.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("index.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		//PrintWriter pw = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDao userDao = new UserDaoImpl();
		User user = null;
		try {
			
			user = userDao.getUserByNameAndPass(username, password);
			
		} catch (EmployeeDoesNotExistException e) {
			response.sendRedirect("error");
			session.setAttribute("problem", "incorrect password");
			response.sendRedirect("login");
			return;
		}
		
		session.setAttribute("username", user.getUsername());
		session.setAttribute("userId", user.getUserId());
		session.setAttribute("email",user.getEmail());
		session.setAttribute("problem", null);
		response.sendRedirect("profile");
		
	}

}
