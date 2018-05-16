package com.Revature.Exceptions;

public class AccountHasNoTransactionHistoryException  extends Exception{


	/**
	 * 
	 */
	private static final long serialVersionUID = -57132913313219586L;

	public AccountHasNoTransactionHistoryException() {
		super("The account name you have entered has no existing transaction history.\n");
		// TODO Auto-generated constructor stub
	}

	
	
	
}
