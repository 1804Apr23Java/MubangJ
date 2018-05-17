package com.revature.exceptions;

public class CreateEmployeeFailedException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CreateEmployeeFailedException() {
		super("Failed to create employee.");
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
		
}
