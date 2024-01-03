package dev.syntax.oop.step09polymorphism.step02param;

public class App {

	public static void main(String[] args) {
		Person p = new Person();
		Animal cat = new Cat("츄르");
		Animal dog = new Dog("바니");
		Animal a = new Animal("동물");
		
//		Animal[] animals = new Animal[3];
//		animals[0] = cat;
//		animals[1] = dog;
		
		p.walk(dog);
		p.walk(cat);
		p.walk(a);
	}

}
