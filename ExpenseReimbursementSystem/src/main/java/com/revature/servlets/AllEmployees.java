package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.tables.User;

/**
 * Servlet implementation class AllEmployees
 */
public class AllEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDao userDao = new UserDaoImpl();
		List<User> users = null;
		
		users = userDao.getUsers();

		ObjectMapper om = new ObjectMapper();
		
		String usersString = om.writeValueAsString(users);
		response.getWriter().write("{\"users\":"+usersString+"}");
	}

}
