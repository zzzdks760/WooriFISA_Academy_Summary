package dev.syntax.oop.step09polymorphism.step02param;

public class Person {

	void walk(Animal animal) {
		
		if (animal instanceof Cat) {
			Cat c = (Cat) animal;
			c.play();
		} else if (animal instanceof Dog) {
			Dog d = (Dog) animal;
			d.play();
		}  else if (animal instanceof Animal) {
			System.out.println("상위 타입 Animal로 형 변환 가능");
		}
		
	}
}
