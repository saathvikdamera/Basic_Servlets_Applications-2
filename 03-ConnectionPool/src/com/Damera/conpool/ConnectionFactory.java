package com.Damera.conpool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory{
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjdb";
	
	private static final String DB_UNAME = "root";
	
	private static final String DB_PWD = "1234";
	
	private static final String SELECT_SQL = " select * from books;";

	public static void main(String[] args) throws SQLException {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(DB_URL);
		config.setUsername(DB_UNAME);
		config.setPassword(DB_PWD);
		config.setDriverClassName("com.mysql.jdbc.Driver");
		
		config.setMaximumPoolSize(20);
		config.setMinimumIdle(5);
		
		HikariDataSource ds = new HikariDataSource(config);
		
		Connection con = ds.getConnection();	
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SELECT_SQL);
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"---"+rs.getString(2)+"---"+rs.getDouble(3));
		}
		
		
	}
	

}
