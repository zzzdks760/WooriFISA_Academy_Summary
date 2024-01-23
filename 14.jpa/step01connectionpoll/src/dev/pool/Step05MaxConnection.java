package dev.pool;

import java.sql.Connection;
import java.sql.SQLException;

public class Step05MaxConnection {

	public static void main(String[] args) throws SQLException{
		Connection connection1 = Step04HikariCPDataSource.getConnection();
		Connection connection2 = Step04HikariCPDataSource.getConnection();
		Connection connection3 = Step04HikariCPDataSource.getConnection();
		Connection connection4 = Step04HikariCPDataSource.getConnection();
		Connection connection5 = Step04HikariCPDataSource.getConnection();
		Connection connection6 = Step04HikariCPDataSource.getConnection();
		Connection connection7 = Step04HikariCPDataSource.getConnection();
		Connection connection8 = Step04HikariCPDataSource.getConnection();
		Connection connection9 = Step04HikariCPDataSource.getConnection();
		Connection connection10 = Step04HikariCPDataSource.getConnection();
		
		Connection connection = Step04HikariCPDataSource.getConnection();
		while (true) {}
	}

}
