package dev.syntax.oop.step01class;

public class MouseWorld {

	public static void main(String[] args) {
		Mouse mouse = new Mouse();
		mouse.sing();
		
		mouse.name = "제리";
		mouse.sing();
		
		System.out.println(mouse.age);
		
//		Mouse jamie = null;
//		System.out.println(jamie.age);
//		jamie.sing();
	}
}
