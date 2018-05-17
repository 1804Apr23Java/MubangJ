package com.revature.exceptions;

public class UsernameExistException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsernameExistException() {
		super("Must provide a valid username.");
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
