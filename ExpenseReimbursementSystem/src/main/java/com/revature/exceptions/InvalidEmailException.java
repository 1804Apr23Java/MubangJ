package com.revature.exceptions;

public class InvalidEmailException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidEmailException() {
		super("Must provide a valid email.");
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
	
}
