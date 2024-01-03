package dev.syntax.oop.step06extends;

public class A {
	private int age;
	
	void methodA() {
		System.out.println("methodA() called");
	}
	
	public A (int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
}
