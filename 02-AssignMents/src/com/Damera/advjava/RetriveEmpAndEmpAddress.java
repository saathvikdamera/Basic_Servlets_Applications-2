package com.Damera.advjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class RetriveEmpAndEmpAddress {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb" ;
	
	private static final String DB_UNAME = "root";
	
	private static final String DB_PWD = "1234";
	
	private static final String SELECT_SQL = "SELECT * FROM EMPDATA e , EMPADDRESS a WHERE e.ID = a.ID AND e.ID = ? ;";

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id :");
		int id = sc.nextInt();
		
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		
		PreparedStatement pstmt = con.prepareStatement(SELECT_SQL);
		pstmt.setInt(1,id);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			System.out.println(rs.getInt(1)+"---"+rs.getString(2)+"---"+rs.getString(3)
			+ "---" + rs.getString(4)+"---"+rs.getString(5)+"---"+rs.getString(6));
		}
		
		con.close();

	}

}
