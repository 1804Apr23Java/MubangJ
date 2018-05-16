package com.Revature.Exceptions;

public class EnterValidOptionException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1542852796110881811L;

	public EnterValidOptionException() {
		
		super("Please Fill Out prompt(s) with valid options.\n");
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
