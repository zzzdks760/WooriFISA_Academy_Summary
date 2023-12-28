package dev.syntax.oop.step03practice;

public class Main {

	public static void main(String[] args) {

		//1번 사람
		Person person = new Person("철수", 5000);
		
		//2번 사람
		Person person2 = new Person("숙자", 10000);

		// 주문		
		Cafe cafe = new Cafe();
		
		// 1번 사람 주문
		cafe.orderAmericano(person);
		
		// 2번 사람 주문
		cafe.orderLatte(person2);

		// 총 매출
		cafe.printTotalPrice();
	}

}
