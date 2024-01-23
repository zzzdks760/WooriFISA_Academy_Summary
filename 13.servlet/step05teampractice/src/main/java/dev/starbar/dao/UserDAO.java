package dev.starbar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dev.starbar.util.DBUtil;
import dev.starbar.util.HikariCPDataSource;

public class UserDAO {
	
	/**
	 * 회원가입
	 */
	public boolean save(String id, String password) {
		
		final String sql = "INSERT INTO user(user_id, password) VALUES(?, ?)";
		
		Connection connection = HikariCPDataSource.getConnection(); 
		
		try (
			PreparedStatement statement = connection.prepareStatement(sql)){
			
			statement.setString(1, id);
			statement.setString(2, password);
			
			int update = statement.executeUpdate();
			
			if (update > 0) {
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 로그인
	 */
	public boolean findUser(String id, String password) {
		final String sql = "SELECT * FROM USER where user_id =? AND password =?";
		
		Connection connection = HikariCPDataSource.getConnection();
		
		try (
			PreparedStatement statement = connection.prepareStatement(sql)){
			
			statement.setString(1, id);
			statement.setString(2, password);
			
			try (ResultSet rs = statement.executeQuery()) {
				if (rs.next()) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}