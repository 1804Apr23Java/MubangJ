package com.Revature.Dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.Revature.Exceptions.CreateEmployeeFailedException;
import com.Revature.Exceptions.EmployeeDoesNotExistException;
import com.Revature.Exceptions.InvalidEmailException;
import com.Revature.Exceptions.InvalidPasswordException;
import com.Revature.Exceptions.UsernameExistException;
import com.Revature.Tables.User;

public interface UserDao {
	
	boolean insertUser(String username, String password, String email, int manager) throws CreateEmployeeFailedException;
	
	User getUser(int userId) throws EmployeeDoesNotExistException;
	List<User> getUsers();
	
	boolean updateUsername(int userId, String username) throws UsernameExistException, SQLIntegrityConstraintViolationException;
	boolean updateUserPass(int userId, String password) throws InvalidPasswordException;
	boolean updateUserEmail(int userId, String email) throws InvalidEmailException, SQLIntegrityConstraintViolationException;
	boolean updateIsManager(int userId, int isManager);

	boolean deleteUser(int userId) throws EmployeeDoesNotExistException;
	
}
