package dev.syntax.oop.step03practice;

public class Car {

	String color;
	int speed;		

	public Car(String color, int speed) {
		this.color = color;
		this.speed = speed;
	}

	public void start() {
		System.out.println(color + " 출발! " + "시속" + speed + "km");
	}
	
}
