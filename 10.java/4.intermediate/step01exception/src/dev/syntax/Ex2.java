package dev.syntax;

public class Ex2 {

	public static void main(String[] args) {
		
		int number = 100;
		int result = 0;
		
		for (int i = 0; i < 10; i++) {
			try {
				result = number / (int) (Math.random() * 10);
			} catch (Exception e) {
//				System.out.println(e);
//				e.getMessage();
				System.out.println(e.getMessage());
			} finally {
				System.out.println(result);
			}
		}
	}

}
