package dev.syntax.oop.step09polymorphism.step01class;

public class App {

	public static void main(String[] args) {
		Animal animal = new Whale();
		Whale whale = new Whale();
		
		animal.sing();
		whale.sing();
		
		whale.swim();
	}

}
