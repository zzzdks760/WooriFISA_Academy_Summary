package dev.syntax.controller;

import java.util.List;

import dev.syntax.dao.TodoDAO;
import dev.syntax.model.Todo;

public class TodoController {
	
	public void findAll() {
//		List<Todo> todos = TodoDAO.findAll();
		
//		TodoView.findAll(todos);
		Todo todo = new Todo(0, null, null, null, false);
		System.out.println(todo);
	}
}
