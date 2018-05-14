package com.Revature.Tables;

public class Managers {
	
	private int managerId;
	private String username;
	private String password;
	private String email;
	
	public Managers(int managerId, String username, String password, String email) {
		super();
		this.managerId = managerId;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
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
	
	
	
}
