package dev.syntax.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import dev.syntax.model.Todo;
import dev.syntax.util.DBUtil;

public class TodoDAO {
	
//	전체 조회
	public List<Todo> findAll() {
		Connection connection = DBUtil.getConnection();
		
		try {
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery("SELECT * FROM todo");
			
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				
				System.out.println(id);
				System.out.println(title);
				
			}
		} catch (Exception e) {
			
		}
		return null;
	}
}
