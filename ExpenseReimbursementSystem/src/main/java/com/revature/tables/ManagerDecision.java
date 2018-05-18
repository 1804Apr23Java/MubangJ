package com.revature.tables;

import java.sql.Blob;

public class ManagerDecision {
	
	private int managerId;
	private int reimbursementId;
	private int employeeId;
	private Blob image;
	private double amount;
	private String reimbursementDate;
	private int decision;
	private String decisionDate;
	
	public ManagerDecision(int managerId, int reimbursementId, int employeeId, Blob image, double amount,
			String reimbursementDate, int decision, String decisionDate) {
		super();
		this.managerId = managerId;
		this.reimbursementId = reimbursementId;
		this.image = image;
		this.amount = amount;
		this.reimbursementDate = reimbursementDate;
		this.decision = decision;
		this.decisionDate = decisionDate;
	}
	
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getReimbursementDate() {
		return reimbursementDate;
	}
	public void setReimbursementDate(String reimbursementDate) {
		this.reimbursementDate = reimbursementDate;
	}
	public int getDecision() {
		return decision;
	}
	public void setDecision(int decision) {
		this.decision = decision;
	}
	public String getDecisionDate() {
		return decisionDate;
	}
	public void setDecisionDate(String decisionDate) {
		this.decisionDate = decisionDate;
	}
	

	
	
}
