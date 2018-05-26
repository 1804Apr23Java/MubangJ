package com.revature.dao;

import com.revature.beans.Users;

public interface UsersDao {
	
	boolean createUser(String username, String password);	
	Users getUserByNameAndPass(String username, String password);
}
