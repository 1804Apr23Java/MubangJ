package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.exceptions.EmployeeDoesNotExistException;
import com.revature.exceptions.ReimbursementDoesNotExistException;
import com.revature.tables.User;

/**
 * Servlet implementation class ApproveOrDenyReimbursement
 */

@WebServlet
@MultipartConfig
public class ApproveOrDenyReimbursement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		//PrintWriter pw = response.getWriter();
		
		int reimbursementId = (int) session.getAttribute("reimburseId");
		
		String decision= request.getParameter("decision");
		System.out.println(decision);
		ReimbursementDao rbsDao = new ReimbursementDaoImpl();
		
		if (decision.equals("approve")) {
			try {
				rbsDao.updateStatus(reimbursementId, 2);
			} catch (ReimbursementDoesNotExistException e) {
				e.printStackTrace();
			}
		} else {
			try {
				rbsDao.updateStatus(reimbursementId, 0);
			} catch (ReimbursementDoesNotExistException e) {
				e.printStackTrace();
			}
		}
				
	}

}
