package com.Revature.Exceptions;

public class InvalidEmailException extends Exception {

	public InvalidEmailException() {
		super("Must provide a valid email.");
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
	
}
