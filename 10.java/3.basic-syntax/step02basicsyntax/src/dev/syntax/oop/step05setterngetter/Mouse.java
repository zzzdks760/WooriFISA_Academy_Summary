package dev.syntax.oop.step05setterngetter;

public class Mouse {
	private int age;
	private String name;

	Mouse(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}
	
	
}
