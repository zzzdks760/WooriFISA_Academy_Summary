package dev.syntax.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Getter
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모든 필드를 받는 생성자
@ToString
public class Todo {
	
	private int id;
	private String title;
	private String description;
	private LocalDate dueDate;
	private boolean isCompleted;

	
}
