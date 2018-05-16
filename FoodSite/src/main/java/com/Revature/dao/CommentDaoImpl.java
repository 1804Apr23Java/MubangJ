package com.Revature.dao;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.Revature.domain.User;

public class CommentDaoImpl implements CommentDao {
	
	private String filename = "./src/main/resources/connections.properties";

	public void putComment(String username, String comment) {

		PreparedStatement pstmt = null;

		try (Connection conn = ConnectionUtil.getConnectionFromFile(filename)) {

			String sql = "INSERT INTO FOODCOMMENTS (USERNAME, F_COMMENT) VALUES (?,?)";
			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, comment);
			pstmt.executeQuery();
			conn.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e3) {
			e3.printStackTrace();
		}

	}

	public List<User> getAllComments() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;


		List <User> comments = null;
		
		try (Connection conn = ConnectionUtil.getConnectionFromFile(filename)) {

			comments = new ArrayList<User>();
			String sql = "SELECT * FROM FOODCOMMENTS WHERE ROWNUM <= 10";
			pstmt = conn.prepareCall(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				comments.add(new User (rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e3) {
			e3.printStackTrace();
		}

		return comments;
	}

}
