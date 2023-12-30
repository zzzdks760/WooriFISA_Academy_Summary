package dev.syntax.oop.step06extends;

public class B extends A{
	
	public B (int age) {
		super(age);
	}
	
	void methodB() {
		System.out.printf("A 클래스의 age 필드: %d \n", getAge());
		methodA();
	}
	
	void methodA() {
		System.out.println("B 클래스 정의 메서드");
	}
}
