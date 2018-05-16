package com.Revature.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	private static String filename = "connections.properties";

	
	public static Connection getConnectionFromFile() throws IOException, SQLException {
		Properties prop = new Properties();
		InputStream in = new FileInputStream(filename);
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		return DriverManager.getConnection(url,username,password);
	}
	
//	public static Connection getConnectionFromFile(String filename) throws IOException, SQLException {
//
//		String url = "jdbc:oracle:thin:@apr23java.clp8jwsxbcb2.us-east-2.rds.amazonaws.com:1521:ORCL";
//		String username = "guest2";
//		String password = "p4ssw0rd";
//		return DriverManager.getConnection(url,username,password);
//	}
	
	
}