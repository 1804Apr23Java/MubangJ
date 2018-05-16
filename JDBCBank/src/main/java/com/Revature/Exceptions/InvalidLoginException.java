package com.Revature.Exceptions;

public class InvalidLoginException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3738455957104504937L;

	public InvalidLoginException() {
		super("Invalid Username or Password.\n");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
	
}
