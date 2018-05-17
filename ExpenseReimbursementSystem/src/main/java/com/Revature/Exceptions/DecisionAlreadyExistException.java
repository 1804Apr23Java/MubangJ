package com.Revature.Exceptions;

public class DecisionAlreadyExistException extends Exception {

	public DecisionAlreadyExistException() {
		super("The manager has already made a decision on this reimbursement request.");
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
