package com.Revature.Dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.Revature.Exceptions.CreateEmployeeFailedException;
import com.Revature.Exceptions.EmployeeDoesNotExistException;
import com.Revature.Exceptions.InvalidEmailException;
import com.Revature.Exceptions.InvalidPasswordException;
import com.Revature.Exceptions.UsernameExistException;
import com.Revature.Tables.Employee;

public interface EmployeeDao {
	
	boolean insertUser(String username, String password, String email) throws CreateEmployeeFailedException;
	
	Employee getEmployee(int employeeId) throws EmployeeDoesNotExistException;
	List<Employee> getEmployees();
	
	boolean updateEmployeeUser(int employeeId, String username) throws UsernameExistException, SQLIntegrityConstraintViolationException;
	boolean updateEmployeePass(int employeeId, String password) throws InvalidPasswordException;
	boolean updateEmployeeEmail(int employeeId, String email) throws InvalidEmailException, SQLIntegrityConstraintViolationException;

	boolean deleteEmployee(int employeeId) throws EmployeeDoesNotExistException;
	
}
