package com.Damera.advjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class RetrieveEmployee {
    
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb" ;
	
	private static final String DB_UNAME = "root";
	
	private static final String DB_PWD = "1234";
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Department :");
		String dept = sc.next();
		System.out.println("Enter Gender :");
		String gender = sc.next();
		System.out.println("Enter Work Location :");
		String workLocation = sc.next();
		
		String SELECT_SQL = "select * from employee where 1=1";
		
		StringBuilder sb = new StringBuilder(SELECT_SQL);
		
		if(dept != null && !dept.equals("null")) {
			sb.append(" and emp_dept = ?");
		}
		
		if(gender != null && !gender.equals("null")) {
			sb.append(" and emp_gender = ?");
		}
		
		if(workLocation != null && !workLocation.equals("null")) {
			sb.append(" and work_location = ? ");
		}
				
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		
		PreparedStatement pstmt = con.prepareStatement(SELECT_SQL);

		int index = 1;

		if(dept != null && !dept.equals("null")){
			pstmt.setString(index, dept);
			index++;
		}
		
		if(gender != null && !gender.equals("null")){
			pstmt.setString(index, gender);
			index++;
		}
		
		if(workLocation != null && !workLocation.equals("null")) {
			pstmt.setString(index, workLocation);
		}
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			System.out.println(rs.getInt(1)+"---" +rs.getString(2)+"---"+rs.getInt(3)+"---"+
		rs.getString(4)+"---"+rs.getString(5)+"---"+rs.getString(6));
		}
		
		con.close();
	}

}