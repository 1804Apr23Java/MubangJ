package com.revature.dao;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.revature.exceptions.DecisionAlreadyExistException;
import com.revature.exceptions.DecisionDoesNotExistException;
import com.revature.tables.ManagerDecision;
import com.revature.util.ConnectionUtil;

public class ManagerDecisionDaoImpl implements ManagerDecisionDao {

	@Override
	public boolean createDecision(int managerId, int reimbursementId, int decision)
			throws DecisionAlreadyExistException {
		
		PreparedStatement pstmt = null;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile()) {
			
			String sql = "INSERT INTO MANAGERDECISION (MANAGERID, REIMBURSEMENTID, DECISION) VALUES (?,?,?)";
			pstmt = conn.prepareCall(sql);
			pstmt.setInt(1, managerId);
			pstmt.setInt(2, reimbursementId);
			pstmt.setInt(3, decision);

			int i = pstmt.executeUpdate();
			conn.close();

			if (i > 0) return true;
			else throw new DecisionAlreadyExistException();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLIntegrityConstraintViolationException e2) {
			throw new DecisionAlreadyExistException();
		} catch (SQLException e3) {
			e3.printStackTrace();
		}
		return false;
	}

	@Override
	public List<ManagerDecision> getDecisions(int managerId) throws DecisionDoesNotExistException {
		PreparedStatement pstmt = null;
		List<ManagerDecision> allDecisions = null;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile()) {
			
			String sql = "SELECT m.MANAGERID, m.REIMBURSEMENTID, m.DECISION, m.DATETIME AS DECISIONDATE, r.EMPLOYEEID, r.IMAGE, r.AMOUNT, r.DATETIME AS REIMBURSEMENTDATE\n" + 
					"FROM MANAGERDECISION m\n" + 
					"INNER JOIN REIMBURSEMENTS r ON m.REIMBURSEMENTID = r.REIMBURSEMENTID\n" + 
					"WHERE m.MANAGERID = ?";
			pstmt = conn.prepareCall(sql);
			pstmt.setInt(1, managerId);
			ResultSet rs = pstmt.executeQuery();
			
			allDecisions = new ArrayList<>();
			while(rs.next()) {
				
				int managerIdd = rs.getInt("MANAGERID");
				int reimbursementIdd = rs.getInt("REIMBURSEMENTID");
				int employeeId = rs.getInt("EMPLOYEEID");
				int ddecision = rs.getInt("DECISION");
				String ddateTime = rs.getTimestamp("DECISIONDATE").toString();
				Blob image = rs.getBlob("IMAGE");
				double amount = rs.getDouble("AMOUNT");	
				String rdateTime = rs.getTimestamp("REIMBURSEMENTDATE").toString();
				
				allDecisions.add(new ManagerDecision(managerIdd, reimbursementIdd, employeeId, image, amount, rdateTime, ddecision, ddateTime));
			}

			conn.close();
			if (allDecisions.isEmpty()) {
				throw new DecisionDoesNotExistException();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return allDecisions;
	}

	@Override
	public ManagerDecision getDecision(int managerId, int reimbursementId) throws DecisionDoesNotExistException {
		PreparedStatement pstmt = null;
		ManagerDecision decision = null;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile()) {
			
			String sql = "SELECT m.MANAGERID, m.REIMBURSEMENTID, m.DECISION, m.DATETIME AS DECISIONDATE, r.EMPLOYEEID, r.IMAGE, r.AMOUNT, r.DATETIME AS REIMBURSEMENTDATE\n" + 
					"FROM MANAGERDECISION m\n" + 
					"INNER JOIN REIMBURSEMENTS r ON m.REIMBURSEMENTID = r.REIMBURSEMENTID\n" + 
					"WHERE m.MANAGERID = ? AND r.REIMBURSEMENTID = ?";
			pstmt = conn.prepareCall(sql);
			pstmt.setInt(1, managerId);
			pstmt.setInt(2, reimbursementId);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				int managerIdd = rs.getInt("MANAGERID");
				int reimbursementIdd = rs.getInt("REIMBURSEMENTID");
				int employeeId = rs.getInt("EMPLOYEEID");
				int ddecision = rs.getInt("DECISION");
				String ddateTime = rs.getTimestamp("DECISIONDATE").toString();
				Blob image = rs.getBlob("IMAGE");
				double amount = rs.getDouble("AMOUNT");	
				String rdateTime = rs.getTimestamp("REIMBURSEMENTDATE").toString();
				
				decision = new ManagerDecision(managerIdd, reimbursementIdd, employeeId, image, amount, rdateTime, ddecision, ddateTime);
			} else {
				throw new DecisionDoesNotExistException();
			}

			conn.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return decision;
	}

	@Override
	public boolean updateDecision(int managerId, int reimbursementId, int decision)
			throws DecisionDoesNotExistException {
		
		PreparedStatement pstmt = null;

		try(Connection conn = ConnectionUtil.getConnectionFromFile()) {

			String sql = "UPDATE MANAGERDECISION SET DECISION = ? WHERE MANAGERID = ? AND REIMBURSEMENTID = ?";
			pstmt = conn.prepareCall(sql);
			pstmt.setInt(1, decision);
			pstmt.setInt(2, managerId);
			pstmt.setInt(3, reimbursementId);
			int i = pstmt.executeUpdate();
			
			conn.close();
			if (i > 0) return true;
			else throw new DecisionDoesNotExistException();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch (SQLException e3) {
			e3.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteDecision(int managerId, int reimbursementId) throws DecisionDoesNotExistException {
		PreparedStatement pstmt = null;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile()) {
			
			String sql = "DELETE FROM MANAGERDECISION WHERE MANAGERID = ? AND REIMBURSEMENTID = ?";
			pstmt = conn.prepareCall(sql);
			pstmt.setInt(1, managerId);
			pstmt.setInt(2, reimbursementId);
			int i = pstmt.executeUpdate();
			conn.close();

			if (i > 0) return true;
			else throw new DecisionDoesNotExistException(); 
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		catch (SQLException e2) {
			e2.printStackTrace();
		}
		return false;
	}

}
