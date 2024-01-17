package dev.syntax;

import java.sql.SQLException;

import dev.cls.Console;
import dev.syntax.controller.TodoController;

public class APP {

	public static void main(String[] args) throws SQLException {
		TodoController todoController = new TodoController();
		todoController.findAll();
		Console.print("Hello");
	}

}
