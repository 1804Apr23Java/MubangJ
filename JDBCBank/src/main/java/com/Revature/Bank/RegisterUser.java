package com.Revature.Bank;



import com.Revature.Dao.UserDaoImpl;

public class RegisterUser {

	private String username;
	private String password;
	private UserDaoImpl userDao = new UserDaoImpl();
	
	public RegisterUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
		
	public boolean userExist() {
		
		
		if(userDao.getUserByName(username) == null) {
			userDao.insertUser(username, password);
			System.out.println("Account Successfully Created\n");
			return false;
		}
		
		if(userDao.getUserByName(username) != null) {
			System.out.println("The user already exist\n");
			return true;
		}
		return false;

	}

}
