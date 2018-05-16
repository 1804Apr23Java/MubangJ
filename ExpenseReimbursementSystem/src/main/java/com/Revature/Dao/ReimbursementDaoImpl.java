package com.Revature.Dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.Revature.Exceptions.InvalidImageException;
import com.Revature.Exceptions.ReimbursementDoesNotExistException;
import com.Revature.Tables.Reimbursement;

public class ReimbursementDaoImpl implements ReimbursementDao {
	

	@Override
	public boolean insertReimbursement(int employeeId, File image, int status) throws InvalidImageException {
		
		PreparedStatement pstmt = null;
		InputStream inputstream = null;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile()) {
			// inputstream = part.getInputStream();
			inputstream = new FileInputStream(image);
			
			String sql = "INSERT INTO REIMBURSEMENTS (EMPLOYEEID, IMAGE, STATUS) VALUES (?,?,?)";
			pstmt = conn.prepareCall(sql);
			pstmt.setInt(1, employeeId);
			if (inputstream != null) {
				pstmt.setBlob(2, inputstream);
			}
			pstmt.setInt(3, status);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getReimbursements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateImage(int reimbursementId, File image) throws InvalidImageException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateStatus(int reimbursementId, int status) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteReimbursement(int reimbursementId) throws ReimbursementDoesNotExistException {
		// TODO Auto-generated method stub
		return false;
	}
	
}
