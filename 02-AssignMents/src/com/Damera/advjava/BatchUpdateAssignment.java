package com.Damera.advjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchUpdateAssignment {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb" ;
	
	private static final String DB_UNAME = "root";
	
	private static final String DB_PWD = "1234";
	
	public static void main(String[] args) throws Exception {
		
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		
		Statement stmt = con.createStatement();
		
		stmt.addBatch("insert into books values(104,'AI',1300)");
		stmt.addBatch("insert into books values(105,'Php',1100)");
		stmt.addBatch("insert into books values(106,'Nodejs',900)");
		
		int[] batch = stmt.executeBatch();
		
		System.out.println("Rows Inserted :: " + batch.length);
		
	}
}
