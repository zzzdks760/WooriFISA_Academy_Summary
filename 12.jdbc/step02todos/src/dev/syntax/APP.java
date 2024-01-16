package dev.syntax;

import dev.syntax.model.Todo;
import dev.syntax.util.DBUtil;

public class APP {

	public static void main(String[] args) {
		DBUtil.getConnection();
		Todo todo = new Todo(0, null, null, null, false);
		System.out.println(todo.getId());
	}

}
