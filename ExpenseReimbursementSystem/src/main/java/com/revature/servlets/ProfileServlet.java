package com.revature.servlets;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.exceptions.EmployeeDoesNotExistException;
import com.revature.exceptions.InvalidPasswordException;
import com.revature.exceptions.UsernameExistException;


/**
 * Servlet implementation class ProfileServlet
 */

@WebServlet
@MultipartConfig
public class ProfileServlet extends HttpServlet {
       
	private static final long serialVersionUID = 6813596748678105106L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		 get the current Session or a null
		HttpSession session = req.getSession(false);
//		 check whether a Session exists
		
		if (session != null && session.getAttribute("username") != null) {

			req.getRequestDispatcher("profile.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("login");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		
		String firstVal = (String) req.getParameter("firstInputVal");
        String secondVal = (String) req.getParameter("secondInputVal");
        String thirdVal = (String) req.getParameter("thirdInputVal");
                
        System.out.println(firstVal);
        System.out.println(secondVal);
        System.out.println(thirdVal);
        
         UserDao userDao = new UserDaoImpl();
         
         if (firstVal.equals(session.getAttribute("username"))) {
         	if (secondVal.equals(thirdVal)) {
             	try {
 					userDao.updateUsername((int) session.getAttribute("userId"), secondVal);
 					session.setAttribute("username", secondVal);

             	} catch (SQLIntegrityConstraintViolationException e) {
 					e.printStackTrace();
 				} catch (UsernameExistException e) {
 					e.printStackTrace();
 				}
         	}
         } else if (firstVal.equals(session.getAttribute("firstName") + " " + session.getAttribute("lastName"))) {
        	 String[] fullName = firstVal.split("\\s+");
        	 if (fullName.length < 2) {
        		 req.getRequestDispatcher("register");
        	 }
        	 String firstname = fullName[0];
        	 String lastname = fullName[1];
        	 System.out.println(fullName[0] + " " + fullName[1]);
         	if (secondVal.equals(thirdVal)) {
         		String[] fullNameUp = secondVal.split("/s+");
         		if (fullNameUp.length < 2) {
         			req.getRequestDispatcher("register");
         		}
         		String firstnameUp = fullNameUp[0];
         		String lastnameUp = fullNameUp[1];
         		try {
					userDao.updateFirstName((int) session.getAttribute("userId"), firstnameUp);
					userDao.updateLastName((int) session.getAttribute("userId"), lastnameUp);
					
					session.setAttribute("firstname", firstnameUp);
					session.setAttribute("lastname", lastnameUp);
					
				} catch (EmployeeDoesNotExistException e) {
					e.printStackTrace();
				}

         	}
         } else if (firstVal.equals(session.getAttribute("password"))) {
        	 System.out.println("here");
         	if (secondVal.equals(thirdVal)) {
 				try {
 					userDao.updateUserPass((int) session.getAttribute("userId"), secondVal);
 				} catch (InvalidPasswordException e) {
 					e.printStackTrace();
 				}
 				
         	}
         }       
	}
	

//	session.setAttribute("email",user.getEmail());
}
