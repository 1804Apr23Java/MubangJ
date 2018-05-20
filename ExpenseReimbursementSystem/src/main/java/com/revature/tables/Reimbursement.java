package com.revature.tables;

import java.sql.Blob;

public class Reimbursement {
	
	// status 0 = pending , status 1 = approved
	
	private int reimbursementId;
	private int employeeId;
	private int managerId;
	private String purpose;
	private String image;
	private int status;
	private double amount;
	private String date;
	
	public Reimbursement(int reimbursementId, int employeeId, int managerId, String purpose, String image, int status,
			double amount, String date) {
		super();
		this.reimbursementId = reimbursementId;
		this.employeeId = employeeId;
		this.managerId = managerId;
		this.purpose = purpose;
		this.image = image;
		this.status = status;
		this.amount = amount;
		this.date = date;
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
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

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	


	
}
