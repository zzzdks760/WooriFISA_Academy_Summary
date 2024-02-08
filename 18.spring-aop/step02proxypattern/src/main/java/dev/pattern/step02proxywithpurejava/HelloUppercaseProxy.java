package dev.pattern.step02proxywithpurejava;

import dev.pattern.step01beforeproxy.Hello;

/*
    HelloTarget의 동작 전후에 별도의 부가 기능을 처리하기 위한 프록시 객체

    데코레이터 패턴을 적용해서 HelloTarget이 동작할 때
    부가 기능을 추가하여 부가 기능이 동작하도록 구현

    부가 기능 - sayHello(), sayGoodBye()가 반환하는 문자를 모두 대문자로 변경하는 처리를 수행

 */
public class HelloUppercaseProxy implements Hello {
    // 타겟 클래스의 동작을 프록시 내부에서 조작할 수 있도록 해야함
    Hello hello;

    public HelloUppercaseProxy(Hello hello) {
        this.hello = hello;
    }

    @Override
    public String sayHello(String name) {

        // proxy 객체가 실제 Target 객체의 sayHello()를 호출
        String helloMessage = hello.sayHello(name); // "Hello yoo"

        // Proxy의 부가 기능 수행 - 모든 문자열을 대문자로 변환 처리
        String upperCased = helloMessage.toUpperCase(); // "HELLO YOO"

        // 부가 기능을 수행 후에 결과값을 반환
        return upperCased;
    }

    @Override
    public String sayGoodBye(String name) {
        return null;
    }
}
