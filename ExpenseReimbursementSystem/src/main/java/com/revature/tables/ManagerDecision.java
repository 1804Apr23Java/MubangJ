package com.revature.tables;

public class ManagerDecision {
	
	private int managerId;
	private int reimbursementId;
	private int decision;
	private String date;
	
	public ManagerDecision(int managerId, int reimbursementId, int decision, String date) {
		super();
		this.managerId = managerId;
		this.reimbursementId = reimbursementId;
		this.decision = decision;
		this.date = date;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public int getDecision() {
		return decision;
	}

	public void setDecision(int decision) {
		this.decision = decision;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
