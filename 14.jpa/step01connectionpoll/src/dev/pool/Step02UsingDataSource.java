package dev.pool;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Step02UsingDataSource {
	
//	DBMS에 연결하여 접속,접근하는 방법
//
//	1. MySQL Workbench(GUI툴)
//	(Graphic User Interface)
//
//	2. 커맨드라인(CLI)
//	Command Line Interface
//
//	3. Java Application(JDBC)
//
//	DB 커넥션 생성을 위한 인터페이스
//	-> DataSource
//
//	1. DataSource datasource = new DriverManagerDataSource( ); // 순수 DriverManager로 사용
//
//	// Apache DBCP 라이브러리 사용 시
//	2. DataSource datasource = new ApacheDBCP();
//
//	// HikariCP 라이브러리 사용 시
//	3. DataSource datasource = new HikariDataSource();


	public static void main(String[] args) throws SQLException {
		// mysql-connector.jar 추가 후 Connection 객체 생성
		final String URL = "jdbc:mysql://localhost:3306/";
		final String DATABASE_NAME = "testdb";
		final String USER = "root";
		final String PASSWORD = "1234";
		
		/**
		 * DriverManage는 DataSource 인터페이스를 구현하지 않았기 때문에 별도의 라이브러리 설치가 필요
		 * org.springframework.jdbc.datasource
		 */
		
		DataSource dataSource = new DriverManagerDataSource(URL + DATABASE_NAME, USER, PASSWORD);
		
		// DriverManagerDataSource - DataSource 인터페이스를 구현한 구현 클래스(구현체)
		Connection connection1 = dataSource.getConnection();
		Connection connection2 = dataSource.getConnection();
		
		System.out.println(connection1);
		System.out.println(connection2);
	}

}
