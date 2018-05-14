package com.Revature.Exceptions;

public class EmployeeDoesNotExistException extends Exception {
	
	public EmployeeDoesNotExistException() {
		super("The specified employee does not exist.");
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
