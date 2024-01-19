package dev.syntax.step05statemanaging.step03practice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	public static Connection getConnection() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			
			final String DB_URL = "jdbc:mysql://localhost:3306/";
			final String DATABASE_NAME = "users"; // 본인 db 이름으로 변경
			final String USER = "root";
			final String PASSWORD = "1234";

			return DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASSWORD);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}
	
}
