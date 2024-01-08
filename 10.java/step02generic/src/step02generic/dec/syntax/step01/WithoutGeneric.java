package step02generic.dec.syntax.step01;

public class WithoutGeneric {
	public static void main (String[] args) {
		// Box 객체 생성
		Box box = new Box();
		Apple apple = new Apple();
		
		// Box에 Apple을 담고 싶음
		box.setApple(apple);
				
		//Box에서 Apple을 꺼내기
		box.getApple();
	}
}
