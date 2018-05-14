package com.Revature.Dao;

import java.io.IOException;
import java.sql.CallableStatement;
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
import com.Revature.Tables.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private String filename = "connection.properties";

	public boolean insertUser(String username, String password, String email) throws CreateEmployeeFailedException {
		PreparedStatement pstmt = null;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename)) {
			
			String sql = "INSERT INTO EMPLOYEES (USERNAME, UPASSWORD, EMAIL) VALUES (?,?,?)";
			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, email);
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

	public Employee getEmployee(int employeeId) throws EmployeeDoesNotExistException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Employee> getEmployees() {
		PreparedStatement pstmt = null;
		List<Employee> employees = new ArrayList();
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile(filename)) {
			
			String sql = "SELECT EMPLOYEEID, USERNAME, UPASSWORD, EMAIL FROM EMPLOYEES";
			pstmt = conn.prepareCall(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int employeeId = rs.getInt("EMPLOYEEID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("UPASSWORD");
				String email = rs.getString("EMAIL");
				employees.add(new Employee(employeeId, username, password, email));
			}
			
			conn.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return employees;
	}

	public boolean updateEmployeeUser(int employeeId, String username) throws UsernameExistException, SQLIntegrityConstraintViolationException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateEmployeePass(int employeeId, String password) throws InvalidPasswordException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateEmployeeEmail(int employeeId, String email) throws InvalidEmailException, SQLIntegrityConstraintViolationException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteEmployee(int employeeId) throws EmployeeDoesNotExistException {
		// TODO Auto-generated method stub
		return false;
	}

}
