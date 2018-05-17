package com.Revature.Tables;

import java.sql.Blob;

public class Reimbursement {
	
	// status 0 = pending , status 1 = approved
	
	private int reimbursementId;
	private int employeeId;
	private Blob image;
	private int status;
	private double amount;
	private String date;

	public Reimbursement(int reimbursementId, int employeeId, Blob image, int status, double amount, String date) {
		super();
		this.reimbursementId = reimbursementId;
		this.employeeId = employeeId;
		this.image = image;
		this.status = status;
		this.amount = amount;
		this.date = date;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
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

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
