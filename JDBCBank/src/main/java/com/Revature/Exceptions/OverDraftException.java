package com.Revature.Exceptions;

public class OverDraftException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4464377692499832543L;

	public OverDraftException() {
		super("You have attempted to withdraw more money then you have in your account.\n");
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
		

}
