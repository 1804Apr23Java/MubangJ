package com.revature.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import com.revature.exceptions.InvalidImageException;
import com.revature.exceptions.ReimbursementDoesNotExistException;
import com.revature.tables.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao {
	

	@Override
	public boolean createReimbursement(int employeeId, int managerId, String purpose, InputStream image, int status, double amount) throws InvalidImageException {
		
		PreparedStatement pstmt = null;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile()) {

			String sql = "INSERT INTO REIMBURSEMENTS (EMPLOYEEID, MANAGERID, PURPOSE, IMAGE, STATUS, AMOUNT) VALUES (?,?,?,?,?,?)";
			pstmt = conn.prepareCall(sql);
			pstmt.setInt(1, employeeId);
			pstmt.setInt(2, managerId);
			pstmt.setString(3, purpose);
			if (image != null) {
				pstmt.setBlob(4, image);
			}
			pstmt.setInt(5, status);
			pstmt.setDouble(6, amount);
			int i = pstmt.executeUpdate();
			conn.close();

			if (i > 0) return true;
			else throw new InvalidImageException();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return false;
	}

	@Override
	public Reimbursement getReimbursement(int reimbursementId) throws ReimbursementDoesNotExistException {
		PreparedStatement pstmt = null;
		Reimbursement rb = null;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile()) {

			String sql = "SELECT r.REIMBURSEMENTID, r.EMPLOYEEID, r.MANAGERID, e.FNAME, e.LNAME, m.FNAME AS MANFNAME, m.LNAME AS MANLNAME, r.PURPOSE, r.STATUS, r.AMOUNT, r.IMAGE, r.DATETIME "
					+ "FROM REIMBURSEMENTS r "
					+ "INNER JOIN USERS e "
					+ "ON r.EMPLOYEEID = e.USERID "
					+ "INNER JOIN USERS m "
					+ "ON r.MANAGERID = m.USERID "
					+ "WHERE r.REIMBURSEMENTID = ?";
			pstmt = conn.prepareCall(sql);
			pstmt.setInt(1, reimbursementId);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				int reimburseId = rs.getInt("REIMBURSEMENTID");
				int employeeIdd = rs.getInt("EMPLOYEEID");
				int managerIdd = rs.getInt("MANAGERID");
				String firstName = rs.getString("FNAME");
				String lastName = rs.getString("LNAME");
				String manFirstName = rs.getString("MANFNAME");
				String manLastName = rs.getString("MANLNAME");
				String purpose = rs.getString("PURPOSE");
				String image = null;
				if (rs.getBytes("IMAGE") != null) {
					image = DatatypeConverter.printBase64Binary(rs.getBytes("IMAGE"));
				} 
				int status = rs.getInt("STATUS");
				
				Timestamp ts = rs.getTimestamp("DATETIME");
				Date date = new Date();
				date.setTime(ts.getTime());
				String dateTime = new SimpleDateFormat("dd/MM/yyyy hh:mm aa").format(date);
//				String dateTime = rs.getTimestamp("DATETIME").toString();
//				DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				double amount = rs.getDouble("AMOUNT");
				rb = new Reimbursement(reimburseId, employeeIdd, managerIdd, firstName, lastName, manFirstName, manLastName, purpose, image, status, amount, dateTime);

			} else {
				throw new ReimbursementDoesNotExistException();
			}
			conn.close();

			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return rb;
	}

	@Override
	public List<Reimbursement> getEmpReimbursements(int employeeId) throws ReimbursementDoesNotExistException{
		PreparedStatement pstmt = null;
		List<Reimbursement> allRbs = null;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile()) {
			
			String sql = "SELECT r.REIMBURSEMENTID, r.EMPLOYEEID, r.MANAGERID, e.FNAME, e.LNAME, m.FNAME AS MANFNAME, m.LNAME AS MANLNAME, r.PURPOSE, r.STATUS, r.AMOUNT, r.DATETIME "
					+ "FROM REIMBURSEMENTS r "
					+ "INNER JOIN USERS e "
					+ "ON r.EMPLOYEEID = e.USERID "
					+ "INNER JOIN USERS m "
					+ "ON r.MANAGERID = m.USERID "
					+ "WHERE r.EMPLOYEEID = ?";		
			pstmt = conn.prepareCall(sql);
			pstmt.setInt(1, employeeId);

			ResultSet rs = pstmt.executeQuery();
			
			allRbs = new ArrayList<>();
			while (rs.next()) {
				int reimburseId = rs.getInt("REIMBURSEMENTID");
				int employeeIdd = rs.getInt("EMPLOYEEID");
				int managerIdd = rs.getInt("MANAGERID");
				String firstName = rs.getString("FNAME");
				String lastName = rs.getString("LNAME");
				String manFirstName = rs.getString("MANFNAME");
				String manLastName = rs.getString("MANLNAME");
				String purpose = rs.getString("PURPOSE");
				int status = rs.getInt("STATUS");
				Timestamp ts = rs.getTimestamp("DATETIME");
				Date date = new Date();
				date.setTime(ts.getTime());
				String dateTime = new SimpleDateFormat("dd/MM/yyyy hh:mm aa").format(date);				double amount = rs.getDouble("AMOUNT");
				
				allRbs.add(new Reimbursement(reimburseId, employeeIdd, managerIdd, firstName, lastName, manFirstName, manLastName, purpose, null, status, amount, dateTime));

			} 
			
			conn.close();
			
			if(allRbs.isEmpty()) {
				throw new ReimbursementDoesNotExistException();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return allRbs;
	}
	
	@Override
	public List<Reimbursement> getManReimbursements() throws ReimbursementDoesNotExistException{
		PreparedStatement pstmt = null;
		List<Reimbursement> allRbs = null;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile()) {
			
			String sql = "SELECT r.REIMBURSEMENTID, r.EMPLOYEEID, r.MANAGERID, e.FNAME, e.LNAME, m.FNAME AS MANFNAME, m.LNAME AS MANLNAME, r.PURPOSE, r.STATUS, r.AMOUNT, r.DATETIME "
					+ "FROM REIMBURSEMENTS r "
					+ "INNER JOIN USERS e "
					+ "ON r.EMPLOYEEID = e.USERID "
					+ "INNER JOIN USERS m "
					+ "ON r.MANAGERID = m.USERID ";
			pstmt = conn.prepareCall(sql);
			ResultSet rs = pstmt.executeQuery();
			
			allRbs = new ArrayList<>();
			while (rs.next()) {
				
				int reimburseId = rs.getInt("REIMBURSEMENTID");
				int employeeIdd = rs.getInt("EMPLOYEEID");
				int managerIdd = rs.getInt("MANAGERID");
				String firstName = rs.getString("FNAME");
				String lastName = rs.getString("LNAME");
				String manFirstName = rs.getString("MANFNAME");
				String manLastName = rs.getString("MANLNAME");
				String purpose = rs.getString("PURPOSE");
				int status = rs.getInt("STATUS");
				Timestamp ts = rs.getTimestamp("DATETIME");
				Date date = new Date();
				date.setTime(ts.getTime());
				String dateTime = new SimpleDateFormat("dd/MM/yyyy hh:mm a").format(date);				double amount = rs.getDouble("AMOUNT");
				
				allRbs.add(new Reimbursement(reimburseId, employeeIdd, managerIdd, firstName, lastName, manFirstName, manLastName, purpose, null, status, amount, dateTime));

			} 
			
			conn.close();
			
			if(allRbs.isEmpty()) {
				throw new ReimbursementDoesNotExistException();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return allRbs;
	}

	@Override
	public boolean updateImage(int reimbursementId, File image) throws ReimbursementDoesNotExistException {
		PreparedStatement pstmt = null;
		InputStream inputstream = null;

		try(Connection conn = ConnectionUtil.getConnectionFromFile()) {
			inputstream = new FileInputStream(image);

			String sql = "UPDATE REIMBURSEMENTS SET IMAGE = ? WHERE REIMBURSEMENTID = ?";
			pstmt = conn.prepareCall(sql);
			pstmt.setBlob(1, inputstream);
			pstmt.setInt(2, reimbursementId);
			int i = pstmt.executeUpdate();
			conn.close();

			if (i > 0) return true;
			else throw new ReimbursementDoesNotExistException();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateStatus(int reimbursementId, int status) throws ReimbursementDoesNotExistException {
		PreparedStatement pstmt = null;

		try(Connection conn = ConnectionUtil.getConnectionFromFile()) {

			String sql = "UPDATE REIMBURSEMENTS SET STATUS = ? WHERE REIMBURSEMENTID = ?";
			pstmt = conn.prepareCall(sql);
			pstmt.setInt(1, status);
			pstmt.setInt(2, reimbursementId);
			int i = pstmt.executeUpdate();
			
			conn.close();
			if (i > 0) return true;
			else throw new ReimbursementDoesNotExistException();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch (SQLException e3) {
			e3.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean updateAmount(int reimbursementId, double amount) throws ReimbursementDoesNotExistException {
		PreparedStatement pstmt = null;

		try(Connection conn = ConnectionUtil.getConnectionFromFile()) {

			String sql = "UPDATE REIMBURSEMENTS SET AMOUNT = ? WHERE REIMBURSEMENTID = ?";
			pstmt = conn.prepareCall(sql);
			pstmt.setDouble(1, amount);
			pstmt.setInt(2, reimbursementId);
			int i = pstmt.executeUpdate();
			
			conn.close();
			if (i > 0) return true;
			else throw new ReimbursementDoesNotExistException();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch (SQLException e3) {
			e3.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteReimbursement(int reimbursementId) throws ReimbursementDoesNotExistException {
		PreparedStatement pstmt = null;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile()) {
			
			String sql = "DELETE FROM REIMBURSEMENTS WHERE REIMBURSEMENTID = ?";
			pstmt = conn.prepareCall(sql);
			pstmt.setInt(1, reimbursementId);
			int i = pstmt.executeUpdate();
			conn.close();

			if (i > 0) return true;
			else throw new ReimbursementDoesNotExistException(); 
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		catch (SQLException e2) {
			e2.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteAllReimbursementsByEmpId(int employeeId) throws ReimbursementDoesNotExistException{
		PreparedStatement pstmt = null;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile()) {
			
			String sql = "DELETE FROM REIMBURSEMENTS WHERE EMPLOYEEID = ?";
			pstmt = conn.prepareCall(sql);
			pstmt.setInt(1, employeeId);
			int i = pstmt.executeUpdate();
			conn.close();

			if (i > 0) return true;
			else throw new ReimbursementDoesNotExistException(); 
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		catch (SQLException e2) {
			e2.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteAllReimbursementsByManId(int managerId) throws ReimbursementDoesNotExistException{
		PreparedStatement pstmt = null;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile()) {
			
			String sql = "DELETE FROM REIMBURSEMENTS WHERE MANAGERID = ?";
			pstmt = conn.prepareCall(sql);
			pstmt.setInt(1, managerId);
			int i = pstmt.executeUpdate();
			conn.close();

			if (i > 0) return true;
			else throw new ReimbursementDoesNotExistException(); 
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		catch (SQLException e2) {
			e2.printStackTrace();
		}
		return false;
	}


	
}
