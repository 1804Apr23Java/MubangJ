package com.Revature.ExpenseRTest;

//import static org.junit.Assert.*;

public class ExpenseRTest {
	
	/********************* UserDao Test ***************************/
	
//	@Test
//	public void testAllUsersAreReturnedFromUsersTable() {
//		
//		UserDao userDao = new UserDaoImpl();
//		List<User> allUsers = new ArrayList<>();
//		allUsers = userDao.getUsers();
//		assertEquals(3, allUsers.size());
//	}
//	
//	@Test
//	public void ReturnsUserByIdFromUsersTable() {
//		
//		UserDao userDao = new UserDaoImpl();
//		User user = userDao.getUserById(1);
//		assertEquals("ADMIN", user.getUsername());
//	}
//	
//	@Test
//	public void FailsToReturnUserByIdFromUsersTable() {
//		
//		UserDao userDao = new UserDaoImpl();
//		User user = userDao.getUserById(1000);
//		assertEquals(null, user);
//	}
//	
//	@Test
//	public void ReturnsUserByUsernameFromUsersTable() {
//		
//		UserDao userDao = new UserDaoImpl();
//		User user = userDao.getUserByName("ADMIN");
//		assertEquals("ADMIN", user.getUsername());
//	}
//	
//	@Test
//	public void FailsToReturnUserByUsernameFromUsersTable() {
//		
//		UserDao userDao = new UserDaoImpl();
//		User user = userDao.getUserByName("BILLY");
//		assertEquals(null, user);
//	}
//	
//	
//	@Test
//	public void insertsAUserIntoUsersTable() throws SQLIntegrityConstraintViolationException {
//		UserDao userDao = new UserDaoImpl();
//		assertEquals(false, userDao.insertUser("regularClient", "p4ss"));		
//	}
//	
//	// already exist in database so need to change to false. UNIQUE constraint in database. returns true for users that do not already exist in database. 
//	// for now it throws exception
//	
//	@Test
//	public void testUserPasswordisUpdatedDependingOnOption() {
//		
//		UserDao userDao = new UserDaoImpl();
//		assertEquals(true, userDao.updateUser(25, "p4ss", "password"));
//		
//	}
//	
//	// already exist in database so need to change to false. UNIQUE constraint in 
//	// database returns true for users that do not already exist in database. 
//	// for now it throws exception
//	
//	@Test
//	public void testUserUsernameisUpdatedDependingOnOption() {
//		
//		UserDao userDao = new UserDaoImpl();
//		assertEquals(false, userDao.updateUser(25, "regularclienttt", "username"));
//		
//	}
//	
//	
//	@Test
//	public void doesNotAllowInsertOfExistingUsername() throws SQLIntegrityConstraintViolationException {
//		UserDao userDao = new UserDaoImpl();
//		assertEquals(false, userDao.insertUser("regularClient", "p4sss"));		
//
//	}
//	
//	// after user has been deleted need to change the test to false and it will test for whether user is in database
//	@Test
//	public void deletesAnExistingUser() {
//		UserDao userDao = new UserDaoImpl();
//		assertEquals(false, userDao.deleteUser(33));
//
//	}
	
	
	
	
	/********************* AccountDao Test ***************************/
	
	
	
	
}
	

