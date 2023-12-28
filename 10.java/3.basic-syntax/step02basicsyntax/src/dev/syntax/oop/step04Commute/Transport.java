package dev.syntax.oop.step04Commute;

public class Transport {
	private int passengers;
	private int revenue;
	
	public void board(Student student, int price) {
		if (student.getMoney() >= price) {
			passengers++;
			student.pay(price);
			revenue += price;
		} else {
			System.out.println(student.getName() + "의 잔액이 부족합니다.");
		}
	}
	
	public void transportInfo(String name, String number) {
		System.out.println(name + number + "에 탑승중인 승객은: " + passengers + "명이고, " + "총 매출액은: " + revenue + "입니다.");
	}
}
