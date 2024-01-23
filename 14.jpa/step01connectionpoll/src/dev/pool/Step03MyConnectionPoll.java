package dev.pool;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Step03MyConnectionPoll {

	public static void main(String[] args) {
		
		final String DB_URL = "jdbc:mysql://localhost:3306/";
		final String DATABASE_NAME = "testdb";
		final String USER = "root";
		final String PASSWORD = "1234";
		
		HikariConfig config = new HikariConfig();
		
		config.setJdbcUrl(DB_URL + DATABASE_NAME);
		config.setUsername(USER);
		config.setPassword(PASSWORD);
		
		HikariDataSource dataSource = new HikariDataSource(config);
		
		try {
			Connection connection = dataSource.getConnection();
			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		while (true) {}
	}

}
