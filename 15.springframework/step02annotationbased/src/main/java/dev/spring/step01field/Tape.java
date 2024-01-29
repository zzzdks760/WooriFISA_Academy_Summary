package dev.spring.step01field;

import org.springframework.beans.factory.annotation.Value;

public class Tape {
	@Value("아일랜드")
	private String name; // 테이프 이름
	
	@Value("false")
	private boolean isWorked; // 정상 동작 여부

	public Tape() {
		super();
		System.out.println("Tape() called");
	}

	public Tape(String name, boolean isWorked) {
		super();
		this.name = name;
		this.isWorked = isWorked;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("setName(String name) called()");
		this.name = name;
	}

	public boolean isWorked() {
		return isWorked;
	}

	public void setWorked(boolean isWorked) {
		System.out.println("setWorked(boolean isWorked) called()");
		this.isWorked = isWorked;
	}

	@Override
	public String toString() {
		return "Tape [name=" + name + ", isWorked=" + isWorked + "]";
	}

}
