package dev.syntax.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dev.syntax.model.Todo;
import dev.syntax.util.DBUtil;

/*
 * DAO, Data Access Object의 줄임 표현
 * 실제로 DBMS와 통신을 수행하는 역할 담당
 */
public class TodoDAO {
	
	// DBMS에게 전체 Todo 데이터를 조회하는 쿼리를 수행하는 메서드
	public List<Todo> findAll() {
		List<Todo> todos = new ArrayList<Todo>();
		// DB 접근 코드 작성 부분
		
		// DB 연결 커넥션 수행
		Connection connection = DBUtil.getConnection();
		Statement statement = null; // 지역 변수들은 초기화 시켜야 됨??????
		ResultSet resultSet = null;
		
		// DBMS에게 쿼리(SQL)을 전달할 객체 생성
		try {
		// 쿼리를 실행시키는 executeQuery를 사용하려면 statement객체를 생성해줘야 함.
		statement = connection.createStatement();
		// sql을 문자열 형태로 변수에 보관
//		String selectQuery = "select * from todo"; // sql mapper
		Properties prop = new Properties();
		prop.loadFromXML(new FileInputStream("resources/sql_mapper.xml"));
		final String selectQuery = prop.getProperty("getTodos");
		
		// 위 쿼리를 실행시키는 코드를 ResultSet형태로 반환하니 resultSet객체에 담아 둠.
		resultSet = statement.executeQuery(selectQuery); // resultset 객체 안에 표 형태로 들어있음
		
		// resultSet.next() -> 값이 들어오면, true
		while(resultSet.next()) { // resultSet을 가지고 원하는 값들을 넣어줘서 보냄
			int id = resultSet.getInt("id");
			String title = resultSet.getString("title");
			String description = resultSet.getString("description");
			
			// java.sql.Date
			Date date = resultSet.getDate("due_date");
			LocalDate dueDate = date.toLocalDate();
			
			boolean isCompleted = resultSet.getBoolean("is_completed");
			
			todos.add(new Todo(id, title, description, dueDate, isCompleted));
		}
		
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			// 자원 해제(역순으로 해제)
			try {
				resultSet.close();
				statement.close();
				connection.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return todos;
	}
	
//	Java 7 이후 - try-with-resources
	
	public List<Todo> findAll2() {
		List<Todo> todos = new ArrayList<Todo>();

		try (	Connection connection = DBUtil.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM todo");
				
				) {
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String description = resultSet.getString("description");
				
				//java.sql.Date
				Date date = resultSet.getDate("due_date");
				LocalDate dueDate = date.toLocalDate();
				
				boolean isCompleted = resultSet.getBoolean("is_completed");
				todos.add(new Todo(id, title, description, dueDate, isCompleted));
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return todos;
	}
	
	// 인수로 전달받은 id값으로 하나의 Todo를 조회하는 메서드
	public Todo findById(int todoId) throws SQLException { // ex. findById(2); // id가 2번인 Todo 객체를 반환하는 메서드
		Todo todo = null;
		
		// "select * from todo where id = root and password = 1234 or 1 = 1"
		Connection connection = DBUtil.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from todo where id = ?");
		statement.setInt(1, todoId);// ?에 맵핑(바인딩)할 값을 지정, 좌측부터 물음표 개수만큼 넘버링 지정
		ResultSet rs = statement.executeQuery();
		
		try (connection; statement; rs) {
			rs.next();
			int id = rs.getInt("id");
			String title = rs.getString("title");
			String description = rs.getString("description");
			Date dueDate = rs.getDate("due_date");
			int isCompleted = rs.getInt("is_completed");

			todo = new Todo(id, title, description, dueDate.toLocalDate(), isCompleted == 1);

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return todo;
	}
}
