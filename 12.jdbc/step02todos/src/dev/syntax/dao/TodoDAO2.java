package dev.syntax.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dev.syntax.model.Todo;
import dev.syntax.util.DBUtil;

/*
 * DAO, Data Access Object의 줄임 표현
 * 실제로 DBMS와 통신을 수행하는 역할 담당
 */
public class TodoDAO2 {
	public List<Todo> findAll() {
		List<Todo> todos = new ArrayList<>();
		
		try (	Connection connection = DBUtil.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM todo");
				
				){
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
