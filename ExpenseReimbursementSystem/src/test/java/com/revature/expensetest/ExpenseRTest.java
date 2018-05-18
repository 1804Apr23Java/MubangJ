package com.revature.expensetest;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.URISyntaxException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.revature.dao.ManagerDecisionDao;
import com.revature.dao.ManagerDecisionDaoImpl;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.exceptions.CreateEmployeeFailedException;
import com.revature.exceptions.DecisionAlreadyExistException;
import com.revature.exceptions.DecisionDoesNotExistException;
import com.revature.exceptions.EmployeeDoesNotExistException;
import com.revature.exceptions.InvalidEmailException;
import com.revature.exceptions.InvalidImageException;
import com.revature.exceptions.InvalidPasswordException;
import com.revature.exceptions.ReimbursementDoesNotExistException;
import com.revature.exceptions.UsernameExistException;
import com.revature.tables.ManagerDecision;
import com.revature.tables.Reimbursement;

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
	public void getExistingUserFromUsersTableById() throws EmployeeDoesNotExistException {
		assertEquals("newUserUpdated", userDao.getUserById(1).getUsername());
	}
	
	@Test
	public void userDoesNotExistById() throws EmployeeDoesNotExistException {
		expectedException.expect(EmployeeDoesNotExistException.class);
		userDao.getUserById(1000);
	}
	
	@Test
	public void getExistingUserFromUsersTableByNameAndPass() throws EmployeeDoesNotExistException {
		assertEquals("newUser5", userDao.getUserByNameAndPass("newUser5", "newPass5").getUsername());
	}
	
	@Test
	public void userDoesNotExistByNameAndPass() throws EmployeeDoesNotExistException {
		expectedException.expect(EmployeeDoesNotExistException.class);
		userDao.getUserByNameAndPass("newUser100000", "newPass1000000");
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
	public void createReimbursementIntoReimbursementTable() throws InvalidImageException, URISyntaxException {

		File file = new File("./src/main/resources/StatueOfLiberty.jpg");
		boolean worked = rsDao.createReimbursement(1, file, 0, 10000.99);
		assertEquals(true, worked);
		
	}
	
	@Test
	public void getReimbursementFromReimbursementsTable() throws ReimbursementDoesNotExistException {
		
		Reimbursement rbs = rsDao.getReimbursement(1);
		assertEquals(1, rbs.getEmployeeId());
	}
	
	@Test
	public void getAllEmpReimbursementsFromReimbursementsTable() throws ReimbursementDoesNotExistException {
		
		List<Reimbursement> allRbs = rsDao.getEmpReimbursements(1);
		assertEquals(4, allRbs.size());
	}
	
	@Test
	public void FailToGetNonExistentEmpReimbursementsFromReimbursementsTable() throws ReimbursementDoesNotExistException {
		expectedException.expect(ReimbursementDoesNotExistException.class);

		rsDao.getEmpReimbursements(10000);
	}
	
	@Test
	public void getAllManReimbursementsFromReimbursementsTable() throws ReimbursementDoesNotExistException {
		
		List<Reimbursement> allRbs = rsDao.getManReimbursements(0);
		assertEquals(4, allRbs.size());
	}
	
	@Test
	public void FailToGetNonExistentManReimbursementsFromReimbursementsTable() throws ReimbursementDoesNotExistException {
		expectedException.expect(ReimbursementDoesNotExistException.class);

		rsDao.getManReimbursements(10000);
	}
	
	@Test
	public void updateImageInReimbursementsTable() throws ReimbursementDoesNotExistException {
		File file = new File("./src/main/resources/StatueOfLiberty.jpg");
		assertEquals(true, rsDao.updateImage(1, file));
	}
	
	@Test
	public void updateImageInReimbursementsTableFailsForNonExistentReimbursement() throws ReimbursementDoesNotExistException {
		File file = new File("./src/main/resources/StatueOfLiberty.jpg");

		expectedException.expect(ReimbursementDoesNotExistException.class);

		assertEquals(true, rsDao.updateImage(10000, file));
	}
	
	@Test
	public void updateStatusInReimbursementsTable() throws ReimbursementDoesNotExistException {
		assertEquals(true, rsDao.updateStatus(1, 1));
	}
	
	@Test
	public void updateStatusInReimbursementsTableFailsForNonExistentReimbursement() throws ReimbursementDoesNotExistException {
		expectedException.expect(ReimbursementDoesNotExistException.class);

		assertEquals(true, rsDao.updateStatus(10000, 1));
	}

	@Test
	public void updateAmountInReimbursementsTable() throws ReimbursementDoesNotExistException {
		assertEquals(true, rsDao.updateAmount(1, 500.99));
	}

	@Test
	public void updateAmountInReimbursementsTableFailsForNonExistentReimbursement() throws ReimbursementDoesNotExistException {
		expectedException.expect(ReimbursementDoesNotExistException.class);

		assertEquals(true, rsDao.updateAmount(10000, 500.99));
	}
	
	@Test
	public void deleteReimbursementInReimbursementsTable() throws ReimbursementDoesNotExistException {
		// once reimbursement is removed, need to use reimbursementdoesnotexist exception to 
		// catch the expected exception so the test pass
		
		expectedException.expect(ReimbursementDoesNotExistException.class);

		assertEquals(true, rsDao.deleteReimbursement(3));
	}
	
	/********************* ManagerDecisionDao Test  ***************************/

	ManagerDecisionDao manDec = new ManagerDecisionDaoImpl();
	
	// user already exist so will fail next time the test is run. Should be true in assertEquals
	@Test
	public void insertDecisionIntoManagerDecisionTable() throws DecisionAlreadyExistException {

		boolean worked = manDec.createDecision(1, 4, 0);
		assertEquals(true, worked);
		
	}
	
	@Test
	public void failtToInsertExistingDecisionIntoManagerDecisionTable() throws DecisionAlreadyExistException {
		
		expectedException.expect(DecisionAlreadyExistException.class);
		boolean worked = manDec.createDecision(1, 1, 0);
		assertEquals(true, worked);
		
	}
	
	@Test
	public void getAllDecisionsFromManagerDecisionTable() throws DecisionDoesNotExistException {
		
		List<ManagerDecision> allDecisions = manDec.getDecisions(1);
		assertEquals(2, allDecisions.size());
	}
	
	@Test
	public void failToGetNonExistentDecisionsFromManagerDecisionTable() throws DecisionDoesNotExistException {
		
		expectedException.expect(DecisionDoesNotExistException.class);
		manDec.getDecisions(1000000);
	}
	
	@Test
	public void getOneDecisionFromManagerDecisionTable() throws DecisionDoesNotExistException {
		
		ManagerDecision md = manDec.getDecision(1, 1);
		assertEquals(1, md.getDecision());
	}
	
	@Test
	public void failToGetNonExistentDecisionFromManagerDecisionTable() throws DecisionDoesNotExistException {
		
		expectedException.expect(DecisionDoesNotExistException.class);
		manDec.getDecision(1000000, 100000);
	}
	
	@Test 
	public void updateDecisionInManagerDecisionTable() throws DecisionDoesNotExistException {
		
		assertEquals(true, manDec.updateDecision(1, 1, 1));
	}
	
	@Test
	public void failToUpdateNonExistentDecisionInManagerDecisionTable() throws DecisionDoesNotExistException {
	
		expectedException.expect(DecisionDoesNotExistException.class);

		manDec.updateDecision(100000, 1000000, 1);
	}
	
	// should not have expectedException, but the decision has already beeen removed from
	// table therefore the expectedException needs to be included for the test to pass
	
	@Test 
	public void deleteDecisionInManagerDecisionTable() throws DecisionDoesNotExistException {
		expectedException.expect(DecisionDoesNotExistException.class);

		assertEquals(true, manDec.deleteDecision(1,4));
	}
	
	@Test 
	public void failToDeleteNonExistentDecisionInManagerDecisionTable() throws DecisionDoesNotExistException {
		expectedException.expect(DecisionDoesNotExistException.class);
		manDec.deleteDecision(1,4);
	}
}



