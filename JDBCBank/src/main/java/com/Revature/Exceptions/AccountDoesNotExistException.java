package com.Revature.Exceptions;

public class AccountDoesNotExistException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2157310065570678278L;

	public AccountDoesNotExistException() {
		super("The account name you have entered does not exist. Please try again.\n");
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}	
