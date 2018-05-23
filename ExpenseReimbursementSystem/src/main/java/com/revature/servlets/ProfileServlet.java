package com.revature.servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.exceptions.InvalidImageException;

/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
       
	private static final long serialVersionUID = 6813596748678105106L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get the current Session or a null
		HttpSession session = req.getSession(false);
		//check whether a Session exists
//		String username = (String) session.getAttribute("username");
//		String email = (String) session.getAttribute("email");
		
		if (session != null && session.getAttribute("username") != null) {
//			req.setAttribute("username", username);
//			req.setAttribute("email", email);
			
//			resp.sendRedirect("profile");
			req.getRequestDispatcher("profile.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("login");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
        String firstVal = (String) req.getParameter("firstInputVal");
        String secondVal = (String) req.getParameter("secondInputVal");
        String thirdVal = (String) req.getParameter("thirdInputVal");
        
        System.out.println(firstVal);
        System.out.println(secondVal);
        System.out.println(thirdVal);
	}


}
