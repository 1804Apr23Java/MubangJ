package com.Revature.main;


import java.util.List;

import com.Revature.dao.CommentDaoImpl;
import com.Revature.domain.User;

public class Runner {
	public static void main(String[] args) {
		CommentDaoImpl cdi = new CommentDaoImpl();
		
		List<User> comments = cdi.getAllComments();
		
		for (User u: comments)
			System.out.println(u);
		
		
	}
}
