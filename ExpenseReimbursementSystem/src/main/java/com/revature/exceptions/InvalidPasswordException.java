package com.revature.exceptions;

public class InvalidPasswordException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidPasswordException() {
		super("Must provide a valid password.");
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
