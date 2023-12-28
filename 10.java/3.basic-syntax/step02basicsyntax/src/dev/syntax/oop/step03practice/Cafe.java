package dev.syntax.oop.step03practice;

public class Cafe {
	private final Menu Americano = new Menu("아메리카노", 1500);
	private final Menu Juice = new Menu("주스", 2000);
	private final Menu Latte = new Menu("라떼", 2500);
	private int totalPrice;
	
	public Menu orderAmericano(Person person) {
		return orderMenu(person, Americano);
	}
	
	public Menu orderLatte(Person person) {
		return orderMenu(person, Juice);
	}
	
	public Menu orderJuice(Person person) {
		return orderMenu(person, Latte);
	}
	
	public Menu orderMenu(Person person, Menu menu) {
		person.pay(menu.price);
		totalPrice += menu.price;
		printOrderMessage(person, menu);
		return menu;
	}
	
	public void printOrderMessage(Person person, Menu menu) {
		System.out.println(person.getName() + "님이 " + menu.name + "를 주문하셨습니다.");
		System.out.println(menu.price + "원을 결제하였으며, 현재 " + person.getName() + "님의 잔액은 " + person.getMoney() + "원 입니다." + "\n");
	}
	
	public void printTotalPrice() {
		System.out.println("카페 총 매출은 " + this.totalPrice + "원 입니다.");
	}
	
	class Menu {
		private String name;
		private int price;
		
		public Menu(String name, int price) {
			this.name = name;
			this.price = price;
		}
	}
	
}
