package com.bps.dbutil;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DbUtil {
	private static Connection conn =null;
	public static Connection getConnection () throws SQLException
	{
		Driver driver = new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(driver);
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bps","root","root");
		return conn;
		
	}
	

}
