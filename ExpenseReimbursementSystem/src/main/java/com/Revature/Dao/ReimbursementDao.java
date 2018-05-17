package com.Revature.Dao;

import java.io.File;
import java.util.List;

import com.Revature.Exceptions.InvalidImageException;
import com.Revature.Exceptions.ReimbursementDoesNotExistException;
import com.Revature.Tables.Reimbursement;

public interface ReimbursementDao {
	
	boolean createReimbursement(int employeeId, File image, int status, double amount) throws InvalidImageException;
	
	Reimbursement getReimbursement(int reimbursementId) throws ReimbursementDoesNotExistException;
	List<Reimbursement> getReimbursements();
	
	boolean updateImage(int reimbursementId, File image) throws ReimbursementDoesNotExistException;
	boolean updateStatus(int reimbursementId, int status) throws ReimbursementDoesNotExistException;
	boolean updateAmount(int reimbursementId, double amount) throws ReimbursementDoesNotExistException;
	
	boolean deleteReimbursement(int reimbursementId) throws ReimbursementDoesNotExistException;
}
