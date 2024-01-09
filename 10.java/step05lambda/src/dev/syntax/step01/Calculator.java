package dev.syntax.step01;

// Invalid '@FunctionalInterface' annotation; Calculator is not a functional interface
/**
 * 단 하나의 추상 메서드만 선언된 인터페이스를 함수형 인터페이스라고함
 * 
 * 제약조건
 * 일반 인터페이스와는 다르게 함수형 인터페이스는 단 하나의 추상 메서드만 선언해야함
 * 
 * 왜냐하면 int sub(int a, int b);와 같은 뺄셈 기능이 추가될 경우,
    Calculator c2 = (int a, int b) -> a + b; 와 같이 인터페이스(Calculator c2)와 람다식 (int a, int b) -> a + b 이 1:1로 매칭이 불가능해짐

    개발자가 이러한 제약을 잘 준수하였는지 자바 컴파일러를 통해 확인시키기 위해서는 인터페이스 위에 
    @FunctionalInterface를 추가해주어야 함
 */
@FunctionalInterface
public interface Calculator {
	int add(int a, int b);
//	int sub(int a, int b);
}
