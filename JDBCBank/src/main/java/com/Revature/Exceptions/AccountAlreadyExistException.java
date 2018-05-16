package com.Revature.Exceptions;

public class AccountAlreadyExistException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1951338153240053646L;

	public AccountAlreadyExistException() {
		super("The account name you have entered already exist. Please try again.\n");
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
