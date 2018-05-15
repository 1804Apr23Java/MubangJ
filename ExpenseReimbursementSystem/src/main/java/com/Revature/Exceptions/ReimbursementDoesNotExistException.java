package com.Revature.Exceptions;

public class ReimbursementDoesNotExistException extends Exception {
	
	public ReimbursementDoesNotExistException() {
		super("The reimbursement does not exist.");
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}

