package dev.syntax.oop.step03practice;

public class Person {
	private String name;
	private int money;
	
	public Person(String name, int money) {
		this.name = name;
		this.money = money;
	}
	
	public void pay(int money) {
		this.money -= money;
	}

	public String getName() {
		return name;
	}

	public int getMoney() {
		return money;
	}
	
}
