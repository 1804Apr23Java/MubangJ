package com.Revature.Exceptions;

public class UserAlreadyExistException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -497019583428329752L;

	public UserAlreadyExistException() {
		super("The username already exists. Please try another username.\n");
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
