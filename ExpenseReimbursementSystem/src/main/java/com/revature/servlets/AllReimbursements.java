package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.exceptions.ReimbursementDoesNotExistException;
import com.revature.tables.Reimbursement;

/**
 * Servlet implementation class AllReimbursements
 */
public class AllReimbursements extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);

		ReimbursementDao rbs = new ReimbursementDaoImpl();
		int userId = (int) session.getAttribute("userId");
		List<Reimbursement> reimbursements = null;
		try {
			reimbursements = rbs.getEmpReimbursements(userId);
		} catch (ReimbursementDoesNotExistException e) {
		}
		
		
		ObjectMapper om = new ObjectMapper();
		
		String reimbursementsString = om.writeValueAsString(reimbursements);
		response.getWriter().write("{\"reimbursements\":"+reimbursementsString+"}");
	}

}
