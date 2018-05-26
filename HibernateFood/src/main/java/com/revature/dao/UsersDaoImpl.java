package com.revature.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.Users;
import com.revature.util.HibernateUtil;

public class UsersDaoImpl implements UsersDao {

	public boolean createUser(String username, String password) {
		
		
		return false;
	}

	public Users getUserByNameAndPass(String username, String password) {
		
		Session s = HibernateUtil.getSession();
		//what if this was load????
		Criteria cr = s.createCriteria(Users.class);
		cr.add(Restrictions.eq("username", username));
		cr.add(Restrictions.eq("password", password));
//		System.out.println(cr.uniqueResult().toString());
		List<Users> users = cr.list();
		Users user = users.get(0);
		
		s.close();
		return  user;

	}
}
