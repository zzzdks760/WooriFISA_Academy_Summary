package dev.syntax.step03methods;

public class Basic {

	public static void main(String[] args) {
		System.out.println(drinkMachine(1));
	}
	/**
	 * 메서드 작성 규칙
	 * 접근제어자 [static] 반환타입 메서드이름 (타입 파라미터){...}
	 */
	public static String drinkMachine(int number) {
		
		if (number == 1) {
			return "제로콜라";
		} else if (number == 2) {
			return "스프라이트";
		} else if (number == 3) {
			return "환타";
		} else {
			return "기본 음료";
		}
	}
	
	public static void fakeOrDrinkMachine() {
		
//		if (number == 0) {
//			System.out.println("제로콜라를 마시고 싶어");
//		} else if (number == 1) {
//			System.out.println("스프라이트를 마시고 싶어");
//		}
	}
}
