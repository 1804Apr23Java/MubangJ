package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.exceptions.EmployeeDoesNotExistException;
import com.revature.exceptions.ReimbursementDoesNotExistException;
import com.revature.tables.Reimbursement;
import com.revature.tables.User;

/**
 * Servlet implementation class SingleReimbursement
 */

@WebServlet
@MultipartConfig
public class SingleReimbursement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		Reimbursement reimbursement = null;
		
		int reimbursementId = (int) session.getAttribute("reimburseId");
		ReimbursementDao rbsDao = new ReimbursementDaoImpl();
		
		try {
			reimbursement = rbsDao.getReimbursement(reimbursementId);
		} catch (ReimbursementDoesNotExistException e) {
			e.printStackTrace();
		}

		ObjectMapper om = new ObjectMapper();
		
		String reimbursementString = om.writeValueAsString(reimbursement);
		response.getWriter().write("{\"reimbursement\":"+reimbursementString+"}");
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
//		response.setContentType("text/html");
		
		int reimbursementId = Integer.parseInt(request.getParameter("reimburseId"));
		System.out.println(reimbursementId);
		
		session.setAttribute("reimburseId", reimbursementId);
		session.setAttribute("problem", null);
	}

}
