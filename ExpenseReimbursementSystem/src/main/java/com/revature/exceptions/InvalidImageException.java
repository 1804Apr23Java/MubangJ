package com.revature.exceptions;

public class InvalidImageException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidImageException() {
		super("Invalid Image");
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
	
	
	
}
