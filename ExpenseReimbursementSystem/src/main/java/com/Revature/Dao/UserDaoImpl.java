package com.Revature.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.Revature.Exceptions.CreateEmployeeFailedException;
import com.Revature.Exceptions.EmployeeDoesNotExistException;
import com.Revature.Exceptions.InvalidEmailException;
import com.Revature.Exceptions.InvalidPasswordException;
import com.Revature.Exceptions.UsernameExistException;
import com.Revature.Tables.User;

public class UserDaoImpl implements UserDao {

	private String filename = "connection.properties";
	
	@Override
	public boolean insertUser(String username, String password, String email, int manager) throws CreateEmployeeFailedException {
		PreparedStatement pstmt = null;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename)) {
			
			String sql = "INSERT INTO USERS (USERNAME, UPASSWORD, EMAIL, MANAGER) VALUES (?,?,?, ?)";
			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, email);
			pstmt.setInt(4, manager);
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
	public User getUser(int userId) throws EmployeeDoesNotExistException {
		PreparedStatement pstmt = null;
		User user = null;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename)) {
			
			String sql = "SELECT USERID, USERNAME, UPASSWORD, EMAIL, MANAGER FROM USERS WHERE USERID = ?";
			pstmt = conn.prepareCall(sql);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				int userId1 = rs.getInt("USERID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("UPASSWORD");
				String email = rs.getString("EMAIL");
				int isManager = rs.getInt("MANAGER");
				user = new User(userId1, username, password, email, isManager);
				
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
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename)) {
			
			String sql = "SELECT USERID, USERNAME, UPASSWORD, EMAIL, MANAGER FROM USERS";
			pstmt = conn.prepareCall(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int userId = rs.getInt("USERID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("UPASSWORD");
				String email = rs.getString("EMAIL");
				int isManager = rs.getInt("MANAGER");
				users.add(new User(userId, username, password, email, isManager));
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
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename)) {
			
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
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename)) {
			
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
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename)) {
			
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
	public boolean updateIsManager(int userId, int isManager) {
		PreparedStatement pstmt = null;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename)) {
			
			String sql = "UPDATE USERS SET MANAGER = ? WHERE USERID = ?";
			pstmt = conn.prepareCall(sql);
			pstmt.setInt(1, isManager);
			pstmt.setInt(2, userId);
			int i = pstmt.executeUpdate();
			conn.close();

			if (i > 0) return true;
			
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
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename)) {
			
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
