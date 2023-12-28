package dev.syntax.oop.step03practice;

public class CarMain {

	public static void main(String[] args) {
		
		Car car1 = new Car("red", 100);
		Car car2 = new Car("blue", 200);
		Car car3 = new Car("black", 150);
		
		car1.start();
		car2.start();
		car3.start();
		
		System.out.println(car1); // toString()이 호출됨
		
	}

}
