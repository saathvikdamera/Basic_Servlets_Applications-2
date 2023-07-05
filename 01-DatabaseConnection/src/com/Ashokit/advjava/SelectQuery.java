package com.Ashokit.advjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectQuery {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb" ;
	
	private static final String DB_UNAME = "root";
	
	private static final String DB_PWD = "1234";
	
	private static final String SELECT_SQL = " select * from books;";

	public static void main(String[] args) throws Exception {
		
		Connection con = DriverManager.getConnection(DB_URL,DB_UNAME,DB_PWD);
		
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(SELECT_SQL);
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+ "---" + rs.getString(2)+ "---" + rs.getDouble(3));
		}
		
		con.close();

	}

}
