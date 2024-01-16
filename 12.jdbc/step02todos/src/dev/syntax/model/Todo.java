package dev.syntax.model;

import java.time.LocalDate;

import lombok.Getter;
@Getter
public class Todo {
	
	private int id;
	private String title;
	private String description;
	private LocalDate dueDate;
	private boolean isCompleted;
	
	public Todo(int id, String title, String description, LocalDate dueDate, boolean isCompleted) {
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.isCompleted = isCompleted;
	}
	
}
