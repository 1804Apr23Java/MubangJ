package com.revature.dao;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import com.revature.exceptions.InvalidImageException;
import com.revature.exceptions.ReimbursementDoesNotExistException;
import com.revature.tables.Reimbursement;

public interface ReimbursementDao {
	
	boolean createReimbursement(int employeeId, int managerId, String purpose, InputStream image, int status, double amount) throws InvalidImageException;
	
	Reimbursement getReimbursement(int reimbursementId) throws ReimbursementDoesNotExistException;
	List<Reimbursement> getEmpReimbursements(int employeeId) throws ReimbursementDoesNotExistException;
	List<Reimbursement> getManReimbursements() throws ReimbursementDoesNotExistException;

	
	boolean updateImage(int reimbursementId, File image) throws ReimbursementDoesNotExistException;
	boolean updateStatus(int reimbursementId, int status) throws ReimbursementDoesNotExistException;
	boolean updateAmount(int reimbursementId, double amount) throws ReimbursementDoesNotExistException;
	
	boolean deleteReimbursement(int reimbursementId) throws ReimbursementDoesNotExistException;
	boolean deleteAllReimbursementsByEmpId(int employeeId) throws ReimbursementDoesNotExistException;
	boolean deleteAllReimbursementsByManId(int managerId) throws ReimbursementDoesNotExistException;

}
