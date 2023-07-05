package com.Ashokit.advjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TransactionManagement {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb" ;
	
	private static final String DB_UNAME = "root";
	
	private static final String DB_PWD = "1234";
	
    private static final String EMP_SQL = "insert into empdata values(?,?,?);";
    
    private static final String EMP_ADD_SQL = "insert into empaddress values(?,?,?,?);";

	public static void main(String[] args) throws Exception {
		
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		
		con.setAutoCommit(false);
		
		PreparedStatement pstmt = con.prepareStatement(EMP_SQL);
		
		pstmt.setInt(1, 1124);
		pstmt.setString(2, "vishal");
		pstmt.setInt(3, 40000);
		pstmt.executeUpdate();
		
		pstmt = con.prepareStatement(EMP_ADD_SQL);
		
		pstmt.setString(1,"hyd" );
		pstmt.setString(2, "TG");
		pstmt.setString(3, "India");
		pstmt.setInt(4, 1124);
		
		pstmt.executeUpdate();
		
		con.commit();
		
		System.out.println("Records inserted.......");
	
		con.close();

	}

}
