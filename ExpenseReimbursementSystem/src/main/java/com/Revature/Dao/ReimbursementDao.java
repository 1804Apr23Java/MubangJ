package com.Revature.Dao;

import java.io.File;
import java.util.List;

import com.Revature.Exceptions.InvalidImageException;
import com.Revature.Exceptions.ReimbursementDoesNotExistException;
import com.Revature.Tables.Reimbursement;

public interface ReimbursementDao {
	
	boolean insertReimbursement(int employeeId, File image, int status) throws InvalidImageException;
	
	Reimbursement getReimbursement(int reimbursementId) throws ReimbursementDoesNotExistException;
	List<Reimbursement> getReimbursements();
	
	boolean updateImage(int reimbursementId, File image) throws InvalidImageException;
	boolean updateStatus(int reimbursementId, int status);

	boolean deleteReimbursement(int reimbursementId) throws ReimbursementDoesNotExistException;
}
