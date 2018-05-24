package com.revature.tables;

public class User {
	
	private int userId;
	private String username;
	private String password;
	private String fName;
	private String LName;
	private String manFirstName;
	private String manLastName;
	private String email;
	private int managerId;
	private int isManager;
	
	public User(int userId, String username, String password, String fName, String lName, String manFirstName,
			String manLastName, String email, int managerId, int isManager) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.fName = fName;
		LName = lName;
		this.manFirstName = manFirstName;
		this.manLastName = manLastName;
		this.email = email;
		this.managerId = managerId;
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

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getLName() {
		return LName;
	}

	public void setLName(String lName) {
		LName = lName;
	}

	public String getManFirstName() {
		return manFirstName;
	}

	public void setManFirstName(String manFirstName) {
		this.manFirstName = manFirstName;
	}

	public String getManLastName() {
		return manLastName;
	}

	public void setManLastName(String manLastName) {
		this.manLastName = manLastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getIsManager() {
		return isManager;
	}

	public void setIsManager(int isManager) {
		this.isManager = isManager;
	}
	
	
}
