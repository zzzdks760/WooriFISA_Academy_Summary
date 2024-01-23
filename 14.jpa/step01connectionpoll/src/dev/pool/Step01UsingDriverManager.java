package dev.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Step01UsingDriverManager {

	public static void main(String[] args) throws SQLException {
		// mysql-connector.jar 추가 후 Connection 객체 생성
		final String URL = "jdbc:mysql://localhost:3306/";
		final String DATABASE_NAME = "testdb";
		final String USER = "root";
		final String PASSWORD = "1234";
		
		Connection connection1 = 
				DriverManager.getConnection(URL + DATABASE_NAME, USER, PASSWORD);
		Connection connection2 = 
				DriverManager.getConnection(URL + DATABASE_NAME, USER, PASSWORD);
		
		System.out.println(connection1);
		System.out.println(connection2);
		
		while (true) {} // 프로그램이 종료되지 않도록 
		
		// MySQL에서 show processlist;로 세션 2개 생성 여부 확인
	}

}
