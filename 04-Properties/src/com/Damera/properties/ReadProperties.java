package com.Damera.properties;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties {

	public static void main(String[] args) throws Exception {
		
		FileInputStream file = new FileInputStream(new File("db.properties"));
		
		Properties p = new Properties();
		p.load(file);
		
		System.out.println(p);

	}

}
