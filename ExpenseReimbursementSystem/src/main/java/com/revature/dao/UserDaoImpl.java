package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.revature.exceptions.CreateEmployeeFailedException;
import com.revature.exceptions.EmployeeDoesNotExistException;
import com.revature.exceptions.InvalidEmailException;
import com.revature.exceptions.InvalidPasswordException;
import com.revature.exceptions.UsernameExistException;
import com.revature.tables.User;
import com.revature.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {
	
	@Override
	public boolean insertUser(String username, String password, String fName, String lName, String email, int managerId, int isManager) throws CreateEmployeeFailedException {
		PreparedStatement pstmt = null;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile()) {
			
			String sql = "INSERT INTO USERS (USERNAME, UPASSWORD, EMAIL, FNAME, LNAME, MANAGERID, MANAGER) VALUES (?,?,?,?, ?, ?, ?)";
			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, email);
			pstmt.setString(4, fName);
			pstmt.setString(5, lName);
			pstmt.setInt(6, managerId);
			pstmt.setInt(7, isManager);
			int i = pstmt.executeUpdate();
			conn.close();

			if (i > 0) return true;
			else throw new CreateEmployeeFailedException();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLIntegrityConstraintViolationException e2) {
			throw new CreateEmployeeFailedException();
		}
		catch (SQLException e3) {
			e3.printStackTrace();
		}
		return false;
	}
	
	@Override
	public User getUserById(int userId) throws EmployeeDoesNotExistException {
		PreparedStatement pstmt = null;
		User user = null;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile()) {
			
			String sql = "SELECT e.USERID, e.USERNAME, e.UPASSWORD, e.FNAME, e.LNAME, e.EMAIL, e.MANAGERID, m.FNAME AS MANFNAME, m.LNAME AS MANLNAME, e.MANAGER " + 
					"FROM USERS e, USERS m " + 
					"WHERE e.MANAGERID = m.USERID " + 
					"AND e.USERID = ?";
			pstmt = conn.prepareCall(sql);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				int userId1 = rs.getInt("USERID");
				String usernamee = rs.getString("USERNAME");
				String passwordd = rs.getString("UPASSWORD");
				String fName = rs.getString("FNAME");
				String lName = rs.getString("LNAME");
				String manFName = rs.getString("MANFNAME");
				String manLName = rs.getString("MANLNAME");
				String email = rs.getString("EMAIL");
				int managerId = rs.getInt("MANAGERID");
				int isManager = rs.getInt("MANAGER");
				user = new User(userId1, usernamee, passwordd, fName, lName, manFName, manLName, email, managerId, isManager);
				
			} else {
				throw new EmployeeDoesNotExistException();
			}
			
			conn.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return user;
	}
	
	@Override
	public User getUserByNameAndPass(String username, String password) throws EmployeeDoesNotExistException {
		PreparedStatement pstmt = null;
		User user = null;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile()) {
			
			String sql = "SELECT e.USERID, e.USERNAME, e.UPASSWORD, e.FNAME, e.LNAME, e.EMAIL, e.MANAGERID, m.FNAME AS MANFNAME, m.LNAME AS MANLNAME, e.MANAGER " + 
					"FROM USERS e, USERS m " + 
					"WHERE e.MANAGERID = m.USERID AND e.USERNAME = ? AND e.UPASSWORD = ?";
			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				int userId1 = rs.getInt("USERID");
				String usernamee = rs.getString("USERNAME");
				String passwordd = rs.getString("UPASSWORD");
				String fName = rs.getString("FNAME");
				String lName = rs.getString("LNAME");
				String manFName = rs.getString("MANFNAME");
				String manLName = rs.getString("MANLNAME");
				String email = rs.getString("EMAIL");
				int managerId = rs.getInt("MANAGERID");
				int isManager = rs.getInt("MANAGER");
				user = new User(userId1, usernamee, passwordd, fName, lName, manFName, manLName, email, managerId, isManager);
				
			} else {
				throw new EmployeeDoesNotExistException();
			}
			
			conn.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return user;
	}
	
	@Override
	public List<User> getUsers() {
		PreparedStatement pstmt = null;
		List<User> users = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile()) {
			
			String sql = "SELECT e.USERID, e.USERNAME, e.UPASSWORD, e.FNAME, e.LNAME, e.EMAIL, e.MANAGERID, m.FNAME AS MANFNAME, m.LNAME AS MANLNAME, e.MANAGER \n" + 
					"FROM USERS e, USERS m\n" + 
					"WHERE e.MANAGERID = m.USERID";
			pstmt = conn.prepareCall(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int userId = rs.getInt("USERID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("UPASSWORD");
				String fName = rs.getString("FName");
				String lName = rs.getString("LNAME");
				String manFName = rs.getString("MANFNAME");
				String manLName = rs.getString("MANLNAME");
				String email = rs.getString("EMAIL");
				int managerIdd = rs.getInt("MANAGERID");
				int isManager = rs.getInt("MANAGER");
				users.add(new User(userId, username, password, fName, lName, manFName, manLName, email, managerIdd, isManager));			
			}
			
			conn.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return users;
	}
	
	@Override
	public boolean updateUsername(int userId, String username) throws UsernameExistException {
		PreparedStatement pstmt = null;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile()) {
			
			String sql = "UPDATE USERS SET USERNAME = ? WHERE USERID = ?";
			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, username);
			pstmt.setInt(2, userId);
			int i = pstmt.executeUpdate();
			conn.close();

			if (i > 0) return true;
			else throw new UsernameExistException();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLIntegrityConstraintViolationException e2) {
			throw new UsernameExistException();
		}
		catch (SQLException e3) {
			e3.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean updateUserPass(int userId, String password) throws InvalidPasswordException {
		PreparedStatement pstmt = null;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile()) {
			
			String sql = "UPDATE USERS SET UPASSWORD = ? WHERE USERID = ?";
			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, password);
			pstmt.setInt(2, userId);
			int i = pstmt.executeUpdate();
			conn.close();

			if (i > 0) return true;
			else throw new InvalidPasswordException();
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		catch (SQLException e3) {
			e3.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean updateUserEmail(int userId, String email) throws InvalidEmailException {
		PreparedStatement pstmt = null;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile()) {
			
			String sql = "UPDATE USERS SET EMAIL = ? WHERE USERID = ?";
			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, email);
			pstmt.setInt(2, userId);
			int i = pstmt.executeUpdate();
			conn.close();

			if (i > 0) return true;
			else throw new InvalidEmailException();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLIntegrityConstraintViolationException e2) {
			throw new InvalidEmailException();
		}
		catch (SQLException e3) {
			e3.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean updateIsManager(int userId, int isManager) throws EmployeeDoesNotExistException {
		PreparedStatement pstmt = null;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile()) {
			
			String sql = "UPDATE USERS SET MANAGER = ? WHERE USERID = ?";
			pstmt = conn.prepareCall(sql);
			pstmt.setInt(1, isManager);
			pstmt.setInt(2, userId);
			int i = pstmt.executeUpdate();
			conn.close();

			if (i > 0) return true;
			else throw new EmployeeDoesNotExistException(); 

		} catch (IOException e) {
			e.printStackTrace();
		} 
		catch (SQLException e3) {
			e3.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean updateFirstName(int userId, String fName) throws EmployeeDoesNotExistException {
		PreparedStatement pstmt = null;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile()) {
			
			String sql = "UPDATE USERS SET FNAME = ? WHERE USERID = ?";
			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, fName);
			pstmt.setInt(2, userId);
			int i = pstmt.executeUpdate();
			conn.close();

			if (i > 0) return true;
			else throw new EmployeeDoesNotExistException(); 

		} catch (IOException e) {
			e.printStackTrace();
		} 
		catch (SQLException e3) {
			e3.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean updateLastName(int userId, String lName) throws EmployeeDoesNotExistException{
		PreparedStatement pstmt = null;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile()) {
			
			String sql = "UPDATE USERS SET LNAME = ? WHERE USERID = ?";
			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, lName);
			pstmt.setInt(2, userId);
			int i = pstmt.executeUpdate();
			conn.close();

			if (i > 0) return true;
			else throw new EmployeeDoesNotExistException(); 

		} catch (IOException e) {
			e.printStackTrace();
		} 
		catch (SQLException e3) {
			e3.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean deleteUser(int userId) throws EmployeeDoesNotExistException {
		PreparedStatement pstmt = null;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile()) {
			
			String sql = "DELETE FROM USERS WHERE USERID = ?";
			pstmt = conn.prepareCall(sql);
			pstmt.setInt(1, userId);
			int i = pstmt.executeUpdate();
			conn.close();

			if (i > 0) return true;
			else throw new EmployeeDoesNotExistException(); 
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		catch (SQLException e2) {
			e2.printStackTrace();
		}
		return false;
	}


	
}
