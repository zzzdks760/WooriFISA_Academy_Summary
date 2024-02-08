package dev.pattern;

import dev.pattern.step01beforeproxy.Hello;
import dev.pattern.step01beforeproxy.HelloTarget;
import dev.pattern.step02proxywithpurejava.HelloUppercaseProxy;
import dev.pattern.step03dynamicproxy.UppercaseHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @Test
    @DisplayName("Hello 인터페이스를 통해 HelloTarget 객체 사용 테스트")
    public void helloTargetTest() {
        Hello hello = new HelloTarget();

        // HelloTarget에 직접 접근한 상황
        assertEquals(hello.sayHello("yoo"), "Hello yoo");
        // assertEquals - "인수로 전달된 두 값이 서로 같을 거라고 단정한다"
        // 에 대한 성공 / 실패 여부를 테스트
        assertEquals(hello.sayGoodBye("yoo"), "Bye yoo");
    }

    @Test
    @DisplayName("순수 Java로 구현한 데코레이터 패턴 기반의 Proxy 객체 생성 및 동작 테스트")
    public void simpleProxyTestWithPureJava() {

        // 참조변수의 타입은 구현체가 아닌 인터페이스로 작성
        Hello proxyiedHello = new HelloUppercaseProxy(new HelloTarget());

        // proxy 객체에 의해 대문자로 변환되는 부가기능이 적용되어 결과 값이 반환됨
        assertEquals(proxyiedHello.sayHello("yoo"), "HELLO YOO");

    }

    @Test
    @DisplayName("리플렉션 API를 활용하여 런타임 과정에서 동적으로 생성되는 프록시 객체의 동적 테스트")
    public void proxyTestWithDynamicProxy() throws Exception {
        Hello proxiedHello = (Hello) Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[] {Hello.class},
                new UppercaseHandler(new HelloTarget())
        );

        assertEquals("HELLO YOO", proxiedHello.sayHello("yoo"));
    }


}
