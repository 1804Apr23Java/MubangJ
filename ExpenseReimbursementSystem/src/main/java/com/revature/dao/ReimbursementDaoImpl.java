package com.revature.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.exceptions.InvalidImageException;
import com.revature.exceptions.ReimbursementDoesNotExistException;
import com.revature.tables.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao {
	

	@Override
	public boolean createReimbursement(int employeeId, File image, int status, double amount) throws InvalidImageException {
		
		PreparedStatement pstmt = null;
		InputStream inputstream = null;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile()) {
			// inputstream = part.getInputStream();
			inputstream = new FileInputStream(image);
			
			String sql = "INSERT INTO REIMBURSEMENTS (EMPLOYEEID, IMAGE, STATUS, AMOUNT) VALUES (?,?,?, ?)";
			pstmt = conn.prepareCall(sql);
			pstmt.setInt(1, employeeId);
			if (inputstream != null) {
				pstmt.setBlob(2, inputstream);
			}
			pstmt.setInt(3, status);
			pstmt.setDouble(4, amount);
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
			
			String sql = "SELECT REIMBURSEMENTID, EMPLOYEEID, IMAGE, STATUS, AMOUNT, DATETIME FROM REIMBURSEMENTS WHERE REIMBURSEMENTID = ?";
			pstmt = conn.prepareCall(sql);
			pstmt.setInt(1, reimbursementId);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				int reimburseId = rs.getInt("REIMBURSEMENTID");
				int employeeId = rs.getInt("EMPLOYEEID");
				Blob image = rs.getBlob("IMAGE");
				int status = rs.getInt("STATUS");
				String dateTime = rs.getTimestamp("DATETIME").toString();
				double amount = rs.getDouble("AMOUNT");
				
				rb = new Reimbursement(reimburseId, employeeId, image, status, amount, dateTime);

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
	public List<Reimbursement> getReimbursements() {
		PreparedStatement pstmt = null;
		List<Reimbursement> allRbs = null;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile()) {
			
			String sql = "SELECT REIMBURSEMENTID, EMPLOYEEID, IMAGE, STATUS, AMOUNT, DATETIME FROM REIMBURSEMENTS";
			pstmt = conn.prepareCall(sql);
			ResultSet rs = pstmt.executeQuery();
			
			allRbs = new ArrayList<>();
			while (rs.next()) {
				int reimburseId = rs.getInt("REIMBURSEMENTID");
				int employeeId = rs.getInt("EMPLOYEEID");
				Blob image = rs.getBlob("IMAGE");
				int status = rs.getInt("STATUS");
				String dateTime = rs.getTimestamp("DATETIME").toString();
				double amount = rs.getDouble("AMOUNT");
				
				allRbs.add(new Reimbursement(reimburseId, employeeId, image, status, amount, dateTime));

			} 
			
			conn.close();

			
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


	
}
