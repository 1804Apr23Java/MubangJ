package com.revature.exceptions;

public class DecisionDoesNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4094592152782487522L;

	public DecisionDoesNotExistException() {
		super("The decision you are attempting to access does not exist.");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
	
	
}
