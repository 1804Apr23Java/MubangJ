package com.revature.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

public class RequestHelper {

	public static String process(HttpServletRequest req) throws IOException {
		switch (req.getParameter("destination")) {
		case "login":
			return "login";
		case "register":
			return "register";
		case "profile":
			return "profile";
		case "reimbursementrequest":
			return "reimbursementrequest";
		case "session":
			return "session";
		case "reimbursementdecision":
			return "reimbursementdecision";
		default:
			return "error";
		}
	}

}
