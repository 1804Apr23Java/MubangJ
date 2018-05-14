package com.Revature.Exceptions;

public class InvalidPasswordException extends Exception {
	public InvalidPasswordException() {
		super("Must provide a valid password.");
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
