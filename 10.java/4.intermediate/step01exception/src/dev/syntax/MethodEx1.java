package dev.syntax;

public class MethodEx1 {

	public static void main(String[] args) throws Exception {
		try {
			method1();
			method2();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("I'm on a boat");
		}
	}
	
	static void method1() throws Exception {
		throw new Exception();
	}
	
	//method2 작성 후 실행에서 스택이 어떻게 출력되는지 확인
	static void method2() throws Exception {
		throw new Exception();
	}

}
