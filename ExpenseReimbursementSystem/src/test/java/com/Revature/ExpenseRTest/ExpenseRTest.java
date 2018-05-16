package com.Revature.ExpenseRTest;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.URISyntaxException;
import java.sql.SQLIntegrityConstraintViolationException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.Revature.Dao.ReimbursementDao;
import com.Revature.Dao.ReimbursementDaoImpl;
import com.Revature.Dao.UserDao;
import com.Revature.Dao.UserDaoImpl;
import com.Revature.Exceptions.CreateEmployeeFailedException;
import com.Revature.Exceptions.EmployeeDoesNotExistException;
import com.Revature.Exceptions.InvalidEmailException;
import com.Revature.Exceptions.InvalidImageException;
import com.Revature.Exceptions.InvalidPasswordException;
import com.Revature.Exceptions.UsernameExistException;

public class ExpenseRTest {
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	/********************* EmployeeDao Test 
	 * @throws CreateEmployeeFailedException 
	 * @throws SQLIntegrityConstraintViolationException ***************************/
	

	private final UserDao userDao = new UserDaoImpl();
	
	// test returns false when user is already in database since I have a unique constraint on Usernames and emails
	
	@Test
	public void testUserIsinsertedIntoUsersTableAndIfExceptionIsThrown() throws CreateEmployeeFailedException, SQLIntegrityConstraintViolationException {
		// throws exception if username/email exist in table
		expectedException.expect(CreateEmployeeFailedException.class);

		boolean worked = userDao.insertUser("newUser5", "newPass5", "newUser5@gmail.com", 0);
		assertEquals(true, worked);
	}
	
	@Test
	public void getAllEmployeesFromUsersTable() {
		assertEquals(2, userDao.getUsers().size());
	}
	
	@Test
	public void getExistingUserFromUsersTable() throws EmployeeDoesNotExistException {
		assertEquals("newUserUpdated", userDao.getUser(1).getUsername());
	}
	
	@Test
	public void userDoesNotExist() throws EmployeeDoesNotExistException {
		expectedException.expect(EmployeeDoesNotExistException.class);
		userDao.getUser(1000);
	}
	
	@Test
	public void updateUsernameInUsersTable() throws UsernameExistException, SQLIntegrityConstraintViolationException {
		
		assertEquals(true, userDao.updateUsername(1, "newUserUpdated"));
	}
	
	@Test
	public void updateUsernameFailsDueToUsernameAlreadyExistingInTable() throws SQLIntegrityConstraintViolationException, UsernameExistException {
		expectedException.expect(UsernameExistException.class);
		userDao.updateUsername(1, "newUser2");
	}
	
	@Test
	public void updatePasswordInUsersTable() throws InvalidPasswordException, SQLIntegrityConstraintViolationException {
		
//		expectedException.expect(InvalidPasswordException.class);
		assertEquals(true, userDao.updateUserPass(1, "newPassUpdated"));
	}
	
	@Test
	public void updateEmailInUsersTable() throws  SQLIntegrityConstraintViolationException, InvalidEmailException {
		
		assertEquals(true, userDao.updateUserEmail(1, "newUserUpdated@gmail.com"));
	}
	
	@Test
	public void updateEmailFailsDueToEmailAlreadyExistingInTable() throws SQLIntegrityConstraintViolationException, InvalidEmailException {
		
		expectedException.expect(InvalidEmailException.class);
		userDao.updateUserEmail(1, "newUser2@gmail.com");
	}
	
	@Test
	public void updateIsManagerColumnInUsersTable() {
		
		assertEquals(true, userDao.updateIsManager(1, 1));
	}
	
	// need expectedException since user no longer exist
	@Test 
	public void deleteUserFromUsersTable() throws EmployeeDoesNotExistException {
		expectedException.expect(EmployeeDoesNotExistException.class);

		assertEquals(true, userDao.deleteUser(18));
	}
	
	// kind of a repeat of last test
	@Test
	public void deleteUserFailsDueToUserNotExisting() throws EmployeeDoesNotExistException {
		expectedException.expect(EmployeeDoesNotExistException.class);
		userDao.deleteUser(1000);
	}
	
/********************* ReimbursementsDao Test  ***************************/
	
	ReimbursementDao rsDao = new ReimbursementDaoImpl();

	@Test
	public void insertReimbursementIntoReimbursementTable() throws InvalidImageException, URISyntaxException {

		File file = new File("./src/main/resources/StatueOfLiberty.jpg");
		boolean worked = rsDao.insertReimbursement(1, file, 0);
		assertEquals(true, worked);
		
	}
	
}



