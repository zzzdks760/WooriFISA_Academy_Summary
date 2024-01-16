package dev.syntax;

import dev.syntax.controller.TodoController;
import dev.syntax.model.Todo;
import dev.syntax.util.DBUtil;

public class APP {

	public static void main(String[] args) {
		TodoController todoController = new TodoController();
		todoController.findAll();
	}

}
