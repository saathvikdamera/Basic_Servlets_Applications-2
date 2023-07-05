package com.Damera.advjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class RetrieveBooks {
	
    private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb" ;
	
	private static final String DB_UNAME = "root";
	
	private static final String DB_PWD = "1234";

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Price :");
		int price = sc.nextInt();
		
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		
		PreparedStatement pstmt = con.prepareStatement("select * from books where price <= ? ");
		
		pstmt.setInt(1, price);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			System.out.println(rs.getInt(1)+ "---" + rs.getString(2)+"---" + rs.getInt(3));
		}
		
		con.close();
	}
}
