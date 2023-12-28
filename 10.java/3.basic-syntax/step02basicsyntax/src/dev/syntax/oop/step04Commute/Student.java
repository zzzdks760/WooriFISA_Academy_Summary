package dev.syntax.oop.step04Commute;

public class Student {
	private String name;
	private int money;
	
	public void pay(int price) {
		money -= price;
	}
	
	public void studentInfo() {
		System.out.println(name + "의 현재 잔액은: " + money + "원 입니다.");
	}
	
	public Student(String name, int money) {
		this.name = name;
		this.money = money;
	}
	
	public int getMoney() {
		return money;
	}
	
	public String getName() {
		return name;
	}
}
