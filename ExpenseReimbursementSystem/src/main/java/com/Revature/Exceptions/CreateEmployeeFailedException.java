package com.Revature.Exceptions;

public class CreateEmployeeFailedException extends Exception {


	public CreateEmployeeFailedException() {
		super("Failed to create employee.");
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
		
}
