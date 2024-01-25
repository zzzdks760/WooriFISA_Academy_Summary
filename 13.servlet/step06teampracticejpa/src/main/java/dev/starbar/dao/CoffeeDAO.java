package dev.starbar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dev.starbar.model.Coffee;
import dev.starbar.util.DBUtil;
import dev.starbar.util.HikariCPDataSource;

public class CoffeeDAO {
	
	/**
	 * 전체 커피 메뉴 조회
	 */
	public List<Coffee> findAll() {
		final String selectQuery = "SELECT * FROM coffee";
		List<Coffee> coffees = new ArrayList<>();

		try (Connection con = HikariCPDataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(selectQuery);
				ResultSet rs = pstmt.executeQuery();) {

			while (rs.next()) {
				final int id = rs.getInt("id");
				final String name = rs.getString("name");
				final String size = rs.getString("size");
				final int price = rs.getInt("price");

				coffees.add(new Coffee(id, name, size, price));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return coffees;
	}
	
	/**
	 * 커피 메뉴 등록
	 */
	public boolean save(String name, String size, int price) {
		final String sql = "INSERT INTO coffee(name, size, price) VALUES(?, ?, ?)";
		
		try (Connection connection = HikariCPDataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql)){
			
			statement.setString(1, name);
			statement.setString(2, size);
			statement.setInt(3, price);
			
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
	 * 커피 메뉴 수정
	 */
	public boolean update(int id, String name, String size, int price) {
		final String sql = "UPDATE COFFEE SET name=?, size =?, price =? WHERE id =?";
		
		try (Connection connection = HikariCPDataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql)){
			
			statement.setString(1, name);
			statement.setString(2, size);
			statement.setInt(3, price);
			statement.setInt(4, id);
			
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
	 * 커피 메뉴 제거
	 */
	public boolean deleteById(int id) {
		final String sql = "DELETE FROM COFFEE WHERE id =?";
		
		try (Connection connection = HikariCPDataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql)) {
			
			statement.setInt(1, id);
			
			int update = statement.executeUpdate();
			if (update > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}