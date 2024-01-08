package step02generic.dec.syntax.step01;

public class WithoutGenericSolution {
	public static void main (String[] args) {
		// 박스에 바나나 담기
		// 제약조건: Box 클래스 내부에 별도의 Banana 타입의 필드를 선언하면 안됨
		Box fruitBox = new Box();
		Banana banana = new Banana();
		Apple apple = new Apple();
		
//		Apple result = (Apple)fruitBox.setAnyFruit(apple);
//		Banana result2 = (Banana)fruitBox.setAnyFruit(banana);
		
		
	}
}
