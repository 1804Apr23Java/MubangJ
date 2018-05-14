package com.Revature.Exceptions;

public class UsernameExistException extends Exception {
	public UsernameExistException() {
		super("Must provide a valid username.");
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
