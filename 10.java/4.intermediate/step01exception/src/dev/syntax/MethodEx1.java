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
	
	//method2 �ۼ� �� ���࿡�� ������ ��� ��µǴ��� Ȯ��
	static void method2() throws Exception {
		throw new Exception();
	}

}
