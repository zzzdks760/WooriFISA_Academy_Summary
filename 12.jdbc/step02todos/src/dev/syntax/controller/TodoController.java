package dev.syntax.controller;

import java.sql.SQLException;
import java.util.List;

import dev.syntax.dao.TodoDAO;
import dev.syntax.model.Todo;

public class TodoController {
	
	public void findAll() throws SQLException {
		TodoDAO todoDao = new TodoDAO();
		List<Todo> findAll = todoDao.findAll2();
		Todo todo = todoDao.findById(1);
		
		System.out.println(todo);
	}
}
