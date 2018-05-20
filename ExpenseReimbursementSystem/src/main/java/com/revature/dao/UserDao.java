package com.revature.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.revature.exceptions.CreateEmployeeFailedException;
import com.revature.exceptions.EmployeeDoesNotExistException;
import com.revature.exceptions.InvalidEmailException;
import com.revature.exceptions.InvalidPasswordException;
import com.revature.exceptions.UsernameExistException;
import com.revature.tables.User;

public interface UserDao {
	
	boolean insertUser(String username, String password, String FName, String LName, String email, int isManager) throws CreateEmployeeFailedException;
	
	User getUserById(int userId) throws EmployeeDoesNotExistException;
	User getUserByNameAndPass(String username, String password) throws EmployeeDoesNotExistException;
	List<User> getUsers();
	
	boolean updateUsername(int userId, String username) throws UsernameExistException, SQLIntegrityConstraintViolationException;
	boolean updateUserPass(int userId, String password) throws InvalidPasswordException;
	boolean updateUserEmail(int userId, String email) throws InvalidEmailException, SQLIntegrityConstraintViolationException;
	boolean updateIsManager(int userId, int isManager) throws EmployeeDoesNotExistException;
	boolean updateFirstName(int userId, String fName) throws EmployeeDoesNotExistException;
	boolean updateLastName(int userId, String lName) throws EmployeeDoesNotExistException;
	
	boolean deleteUser(int userId) throws EmployeeDoesNotExistException;
	
}
