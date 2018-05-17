package com.revature.exceptions;

public class EmployeeDoesNotExistException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8810636394240578265L;

	public EmployeeDoesNotExistException() {
		super("The specified employee does not exist.");
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
