package dev.syntax.oop.step05setterngetter;

public class Main {

	public static void main(String[] args) {
		Mouse jerry = new Mouse(3, "제리");
		jerry.setAge(10);
		System.out.println(jerry.getAge());
	}

}
