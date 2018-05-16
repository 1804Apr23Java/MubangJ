package com.Revature.Exceptions;

public class UserDoesNotExistException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7585345077553636611L;

	public UserDoesNotExistException() {
		super("The username or password you have entered does not exist.\n");
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
