package com.Revature.Dao;

import java.util.List;

import com.Revature.Exceptions.DecisionAlreadyExistException;
import com.Revature.Exceptions.DecisionDoesNotExistException;
import com.Revature.Tables.ManagerDecision;

public interface ManagerDecisionDao {
	
	boolean createDecision(int managerId, int reimbursement, int decision) throws DecisionAlreadyExistException;
	
	List<ManagerDecision> getDecisions();
	ManagerDecision getDecision(int managerId, int reimbursementId) throws DecisionDoesNotExistException;
	
	boolean updateDecision(int managerId, int reimbursementId, int decision) throws DecisionDoesNotExistException;
	
	boolean deleteDecision(int managerId, int reimbursementId) throws DecisionDoesNotExistException;
}
