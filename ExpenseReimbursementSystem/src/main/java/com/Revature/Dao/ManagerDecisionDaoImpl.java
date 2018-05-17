package com.Revature.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.Revature.Exceptions.DecisionAlreadyExistException;
import com.Revature.Exceptions.DecisionDoesNotExistException;
import com.Revature.Tables.ManagerDecision;

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
	public List<ManagerDecision> getDecisions() {
		PreparedStatement pstmt = null;
		List<ManagerDecision> allDecisions = null;
		
		try(Connection conn = ConnectionUtil.getConnectionFromFile()) {
			
			String sql = "SELECT MANAGERID, REIMBURSEMENTID, DECISION, DATETIME FROM MANAGERDECISION";
			pstmt = conn.prepareCall(sql);
			ResultSet rs = pstmt.executeQuery();
			
			allDecisions = new ArrayList<>();
			while(rs.next()) {
				int managerId = rs.getInt("MANAGERID");
				int reimbursementId = rs.getInt("REIMBURSEMENTID");
				int decision = rs.getInt("DECISION");
				String dateTime = rs.getTimestamp("DATETIME").toString();
				
				allDecisions.add(new ManagerDecision(managerId, reimbursementId, decision, dateTime));
			}

			conn.close();
			
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
			
			String sql = "SELECT MANAGERID, REIMBURSEMENTID, DECISION, DATETIME FROM MANAGERDECISION WHERE MANAGERID = ? AND REIMBURSEMENTID = ?";
			pstmt = conn.prepareCall(sql);
			pstmt.setInt(1, managerId);
			pstmt.setInt(2, reimbursementId);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int managerIdd = rs.getInt("MANAGERID");
				int reimbursementIdd = rs.getInt("REIMBURSEMENTID");
				int ddecision = rs.getInt("DECISION");
				String ddateTime = rs.getTimestamp("DATETIME").toString();
				
				decision = new ManagerDecision(managerIdd, reimbursementIdd, ddecision, ddateTime);
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
