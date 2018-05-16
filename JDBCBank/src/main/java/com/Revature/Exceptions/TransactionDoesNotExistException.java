package com.Revature.Exceptions;

public class TransactionDoesNotExistException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1287060667169833136L;

	public TransactionDoesNotExistException() {
		
		super("The transaction you have entered does not exist.\n");
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
