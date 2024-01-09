package dev.syntax.step01;

public class App {

	public static void main(String[] args) {
		
		// case 1.
		MyCalculator c1 = new MyCalculator();
		c1.add(2, 3);
		
		// case 2. 익면 클래스 기반으로 초기화
		Calculator c2 = new Calculator() {
			
			@Override
			public int add(int a, int b) {
				return a + b;
			}

//			@Override
//			public int sub(int a, int b) {
//				// TODO Auto-generated method stub
//				return a - b;
//			}
		};
		System.out.println(c2.add(3, 5));
		
		// case 3. 람다식 기반으로 작성
		Calculator c3 = (a, b) -> a + b;
//		System.out.println(c3.sub(5, 1));
//		System.out.println(c3.add(5, 7));
		
	}

}
