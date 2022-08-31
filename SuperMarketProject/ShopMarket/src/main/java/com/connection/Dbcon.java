package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbcon {
	
	private static Connection connection = null;
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if(connection==null) {
//			 Register Driver Class
			Class.forName("com.mysql.cj.jdbc.Driver");
//			  Connection to your database
			connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_cart","onserver","onserver");
			
			System.out.println("connected");
		}
		return connection;
	}

}
