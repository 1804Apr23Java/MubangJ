package com.Revature.Exceptions;

public class NoTransactionsForUserException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5085512557367944796L;

	public NoTransactionsForUserException() {
		super("The specified user does not have any transaction history.\n");
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}	
}
