package dev.syntax.oop.step04Commute;

public class Subway {
	private String line;
	private int passenger;
	private int revenue;
	
	public void boardSubway(Student student) {
		if (student.getMoney() >= 1400) {
			student.pay(1400);
			passenger++;
			revenue += 1400;
			System.out.println(student.getName() + " 탑승! " + "지하철 " + line + "에 탑승중인 승객은: " + passenger + "명이고, " + "총 매출액은: " + revenue + "입니다.");
		} else {
			System.out.println(student.getName() + "의 잔액이 부족합니다.");
		}
	}
	
//	public void subwayInfo() {
//		System.out.println(line +"지하철에 탑승중인 승객은: " + passenger + "명이고, " + "총 매출액은: " + revenue + "입니다.");
//	}
	
	public Subway(String line) {
		this.line = line;
	}
}
