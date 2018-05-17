package com.revature.exceptions;

public class DecisionAlreadyExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6129189699167311115L;

	public DecisionAlreadyExistException() {
		super("The manager has already made a decision on this reimbursement request.");
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
