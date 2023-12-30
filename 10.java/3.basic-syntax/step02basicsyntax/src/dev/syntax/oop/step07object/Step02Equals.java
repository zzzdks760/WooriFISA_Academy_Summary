package dev.syntax.oop.step07object;

public class Step02Equals {

	public static void main(String[] args) {
		Dog d1 = new Dog(5);
		System.out.println("m1의 주소값: " + d1);
		Dog d2 = new Dog(5);
		System.out.println("m2의 주소값: " + d2);
		Cat c1 = new Cat(10);
		Cat c2 = new Cat(10);
		
		if (c1.equals(c2)) {
			System.out.println("c1과 c2는 같음");
		} else {
			System.out.println("c1과 c2는 다름");
		}
		
		if (d1.equals(d2)) {
			System.out.println("d1과 d2는 같음");
		} else {
			System.out.println("d1과 d2는 다름");
		}
		
	}

}

class Cat {
	int age;
	
	public Cat(int age) {
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Cat) {
			return age == ((Cat)obj).age;
		} else {
			return false;
		}
	}
	
}

class Dog {
	int age;
	
	public Dog(int age) {
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) { //obj에는 Dog가 들어올 수도 있고, Cat도 들어올 수 있다.
		if (obj != null && obj instanceof Dog) {
			return age == ((Dog)obj).age;
		} else {
			return false;
		}
	}
	
}