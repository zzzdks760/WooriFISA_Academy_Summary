package dev.syntax.oop.step07object;

public class Step01Equals {

	public static void main(String[] args) {
		Mouse m1 = new Mouse(5);
		System.out.println("m1의 주소값: " + m1);
		Mouse m2 = new Mouse(5);
		System.out.println("m2의 주소값: " + m2);
		
		if(m1.equals(m2)) {
			System.out.println("m1과 m2는 같음");
		} else {
			System.out.println("m1과 m2는 다름");
		}
		
	}

}

class Mouse {
	int age;
	
	public Mouse(int age) {
		this.age = age;
	}
}