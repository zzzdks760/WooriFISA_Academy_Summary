package dev.syntax.oop.step01class;

public class MouseWorld2 {

	public static void main(String[] args) {
		Mouse jerry = new Mouse("제리");
		Mouse jeime = new Mouse("제이미");
		Mouse mikky = new Mouse("미키");
		
		jerry = jeime;
		System.out.println(jerry.name);
		jeime = mikky;
		System.out.println(jerry.name);
		System.out.println(jeime.name);
		
		System.out.println(jeime);
	}
}
