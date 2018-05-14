package com.Revature.ExpenseRTest;

import static org.junit.Assert.assertEquals;

import java.sql.SQLIntegrityConstraintViolationException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.Revature.Dao.EmployeeDao;
import com.Revature.Dao.EmployeeDaoImpl;
import com.Revature.Exceptions.CreateEmployeeFailedException;

public class ExpenseRTest {
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	/********************* EmployeeDao Test 
	 * @throws CreateEmployeeFailedException 
	 * @throws SQLIntegrityConstraintViolationException ***************************/
	

	private final EmployeeDao employeeDao = new EmployeeDaoImpl();
	
	// test returns false when user is already in database since I have a unique constraint on Usernames and emails
	
	@Test
	public void testEmployeeIsinsertedIntoEmployeesTableAndIfExceptionIsThrown() throws CreateEmployeeFailedException, SQLIntegrityConstraintViolationException {
		// throws exception if username/email exist in table
		expectedException.expect(CreateEmployeeFailedException.class);

		boolean worked = employeeDao.insertUser("newUser", "newPass", "newUser@gmail.com");
		assertEquals(true, worked);
	}
	
	@Test
	public void getAllEmployeesFromEmployeesTable() {
		assertEquals(1, employeeDao.getEmployees().size());
	}
	
	
}
	

