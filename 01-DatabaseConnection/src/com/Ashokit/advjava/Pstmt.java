package com.Ashokit.advjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Pstmt {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb" ;
	
	private static final String DB_UNAME = "root";
	
	private static final String DB_PWD = "1234";
	
	private static final String INSERT_SQL = "insert into employee values(?,?,?,?,?,?);";

	public static void main(String[] args) throws Exception {
		
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		
		PreparedStatement pstmt = con.prepareStatement(INSERT_SQL);
		pstmt.setInt(1,06);
		pstmt.setString(2, "sudansh");
		pstmt.setInt(3, 9000);
		pstmt.setString(4, "admin");
		pstmt.setString(5, "male");
		pstmt.setString(6, "hyd");
		
		
		int count = pstmt.executeUpdate();
		
		System.out.println("Records inserted :: " + count);
		
		con.close();

	}

}
