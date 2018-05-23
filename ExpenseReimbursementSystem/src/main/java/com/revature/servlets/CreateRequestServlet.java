package com.revature.servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.exceptions.InvalidImageException;

/**
 * Servlet implementation class CreateRequestServlet
 */

@MultipartConfig(maxFileSize = 16177215) // 16MB
public class CreateRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session != null && session.getAttribute("username") != null) {
			
			request.getRequestDispatcher("createReimbursement.jsp").forward(request, response);
			
		} else {
			response.sendRedirect("login");
			
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String purpose = request.getParameter("purpose");
        double amount = Double.parseDouble(request.getParameter("amount"));
               
        InputStream inputStream = null;
        Part filePart = request.getPart("receipt" );
      
        
        if (filePart != null) {
        	inputStream = filePart.getInputStream();
        }
       
        ReimbursementDao rbsDao = new ReimbursementDaoImpl();
        int employeeId = (int) session.getAttribute("userId");
        int managerId = (int) session.getAttribute("managerId");
        try {
			rbsDao.createReimbursement(employeeId, managerId, purpose, filePart.getInputStream(), 1, amount);
		} catch (InvalidImageException e) {
		}
        
        
//        System.out.println(firstName);
//        System.out.println(lastName);
//        System.out.println(purpose);
//        System.out.println(amount);

	}

}
