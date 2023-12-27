package dev.syntax.step02datatypes;

public class Basic5BoolType {

	public static void main(String[] args) {
		// 5. 논리 타입 boolean, 기본값은 false

        // 예/아니오 같은 이진 판별, 조건식 연산의 결과값 등으로 활용됨
        boolean isLogin = true; // 로그인 되었는지 여부 확인용 변수
        boolean result = 1 == 1; // 동등연산자 ==를 활용한 1과 1은 같은가? 에 대한 연산 처리 결과를 result 변수에 초기화
        System.out.println(result);
        // Q. Java에서 1은 true, 0은 false로 취급될까?
        // https://stackoverflow.com/questions/2015071/why-boolean-in-java-takes-only-true-or-false-why-not-1-or-0-alsoㅁㅊ
	}

}
