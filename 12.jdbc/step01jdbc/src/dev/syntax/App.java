package dev.syntax;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/";
	private static final String DATABASE_NAME = "testdb";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";

	public static void main(String[] args) throws SQLException{
		
		Connection connection =  DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASSWORD);
		System.out.println(connection);
	}

}
