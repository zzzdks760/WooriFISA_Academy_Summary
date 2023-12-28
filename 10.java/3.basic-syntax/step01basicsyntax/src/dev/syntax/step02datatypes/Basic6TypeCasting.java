package dev.syntax.step02datatypes;

public class Basic6TypeCasting {

	public static void main(String[] args) {
		byte a = 120;
		int b = 120;
		long c = 120;
		double d = 5.5f;
		
		// 어떤 타입의 허용 범위가 작은 타입에서 큰 타입을 값 저장 가능
		
		// 반대의 경우
		float f = 5.5f;
		
		byte k = (byte)128;
		System.out.println(k); //오버 플로
		
		int l = (int)5.5f;
		System.out.println(l);
		
		long n = 135;
	}

}
