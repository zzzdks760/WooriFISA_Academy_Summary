package dev.syntax.oop.step04Commute;

public class Bus {
	private String number;
	private int passenger;
	private int revenue;
	
	public void boardBus(Student student) {
		if (student.getMoney() >= 2000) {
			student.pay(2000);
			passenger++;
			revenue += 2000;
			System.out.println(student.getName() + " 탑승! " + number +"버스에 탑승중인 승객은: " + passenger + "명이고, " + "총 매출액은: " + revenue + "입니다.");
		} else {
			System.out.println(student.getName() + "의 잔액이 부족합니다.");
		}
	}
	
//	public void busInfo() {
//		System.out.println(number +"버스에 탑승중인 승객은: " + passenger + "명이고, " + "총 매출액은: " + revenue + "입니다.");
//	}
	
	public Bus(String number) {
		this.number = number;
	}
}
