package com.Revature.Tables;

public class User {
	
	private int userId;
	private String username;
	private String password;
	private String email;
	private int isManager;

	public User(int UserId, String username, String password, String email, int isManager) {
		super();
		this.userId = UserId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.isManager = isManager;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getIsManager() {
		return isManager;
	}

	public void setIsManager(int isManager) {
		this.isManager = isManager;
	}
	
	
	
	

}
