package com.Revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.Revature.dao.CommentDaoImpl;
import com.Revature.dao.ConnectionUtil;
import com.Revature.domain.User;

public class Runner {
	public static void main(String[] args) {
		CommentDaoImpl cdi = new CommentDaoImpl();
		
		List<User> comments = cdi.getAllComments();
		
		for (User u: comments)
			System.out.println(u);
		
		
	}
}
