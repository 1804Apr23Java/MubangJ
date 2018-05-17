package com.revature.exceptions;

public class ReimbursementDoesNotExistException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReimbursementDoesNotExistException() {
		super("The reimbursement does not exist.");
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}

