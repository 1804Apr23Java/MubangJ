package com.revature.main;

import org.hibernate.Session;

import com.revature.dao.UsersDao;
import com.revature.dao.UsersDaoImpl;
import com.revature.util.HibernateUtil;

public class Driver {
	
	public static void main(String[] args) {
		
//		init();
		
		UsersDao userDao = new UsersDaoImpl();
		System.out.println(userDao.getUserByNameAndPass("DBrewer", "password").toString());
	}
	
	public static void init() {
		Session s = HibernateUtil.getSession();
		System.out.println(s.isOpen());
		s.close();
		System.out.println(s.isOpen());
	}
}
