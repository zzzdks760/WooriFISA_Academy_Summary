package dev.syntax.oop.step09polymorphism.step02param;

public class Animal {
	String name;

	Animal(String name) {
		this.name = name;
	}

	void play() {
		System.out.println(name + " 과 산책!");
	}
}