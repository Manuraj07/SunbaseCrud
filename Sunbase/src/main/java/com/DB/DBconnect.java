package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {
	private  static Connection con;	
	public static Connection getConnetion() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
			
						
		} catch (Exception e) {
		}
		return con;
	}

}
