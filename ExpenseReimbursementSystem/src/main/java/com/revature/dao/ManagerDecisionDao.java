package com.revature.dao;

import java.util.List;

import com.revature.exceptions.DecisionAlreadyExistException;
import com.revature.exceptions.DecisionDoesNotExistException;
import com.revature.tables.ManagerDecision;

public interface ManagerDecisionDao {
	
	boolean createDecision(int managerId, int reimbursement, int decision) throws DecisionAlreadyExistException;
	
	List<ManagerDecision> getDecisions();
	ManagerDecision getDecision(int managerId, int reimbursementId) throws DecisionDoesNotExistException;
	
	boolean updateDecision(int managerId, int reimbursementId, int decision) throws DecisionDoesNotExistException;
	
	boolean deleteDecision(int managerId, int reimbursementId) throws DecisionDoesNotExistException;
}
