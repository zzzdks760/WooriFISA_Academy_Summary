package dev.syntax.oop.step10abstract.step01;

public class App {

public static void main(String[] args) {
		
		// 추상클래스는 인스턴스 생성 불가
//		Animal a = new Animal();
//		a.sing();
		
		Animal[] animal = new Animal[2];

		animal[0] = new Cat();
		animal[1] = new Dog();
//		animal[2] = new Animal();

		for (Animal a : animal) {
			a.sing();
		}
		
	}
}
