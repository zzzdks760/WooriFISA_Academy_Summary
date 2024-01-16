package dev.syntax.controller;

import dev.syntax.dao.TodoDAO;

public class TodoController {
	
	public void findAll() {
		TodoDAO todoDao = new TodoDAO();
		todoDao.findAll();
	}
}
