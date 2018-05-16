package com.Revature.domain;

public class User {
	public User(int id, String username, String comment) {
		super();
		this.id = id;
		this.username = username;
		this.comment = comment;
	}
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	private String username;
	private String comment;
	@Override
	public String toString() {
		return "User " + username + " said: " + comment;
	}
}
