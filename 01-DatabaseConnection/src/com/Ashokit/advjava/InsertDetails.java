package com.Ashokit.advjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertDetails {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb" ;
	
	private static final String DB_UNAME = "root";
	
	private static final String DB_PWD = "1234";
	
	private static final String INSERT_SQL = "insert into books values(101,'java',1000)";

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(DB_URL,DB_UNAME,DB_PWD);
		
		Statement stmt = con.createStatement();
		
		int rowsEffected = stmt.executeUpdate(INSERT_SQL);
		
		System.out.println("Record Inserted Count ::" + rowsEffected);
		
		con.close();

	}

}
