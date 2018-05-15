package com.Revature.Tables;

public class Reimbursement {
	
	// status 0 = pending , status 1 = approved
	
	private int reimbursementId;
	private int employeeId;
	private long image;
	private int status;
	private String date;
	
	public Reimbursement(int reimbursementId, int employeeId, long image, int status, String date) {
		super();
		this.reimbursementId = reimbursementId;
		this.employeeId = employeeId;
		this.image = image;
		this.status = status;
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

	public long getImage() {
		return image;
	}

	public void setImage(long image) {
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
