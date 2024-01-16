package dev.syntax;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/";
	private static final String DATABASE_NAME = "testdb";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";
//	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//		Class.forName(DRIVER_NAME);
		Connection connection =  DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASSWORD);
		
		System.out.println(connection);
		
//		SQL을 문자열 형태로 변수에 보관
		final String dropTableSQL = "DROP TABLE IF EXISTS todo";
		
		Statement statement = connection.createStatement();
		boolean result = statement.execute(dropTableSQL);
		System.out.println(result);
	}

}