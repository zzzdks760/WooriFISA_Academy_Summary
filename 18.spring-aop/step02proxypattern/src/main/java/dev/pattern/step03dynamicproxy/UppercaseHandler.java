package dev.pattern.step03dynamicproxy;

import dev.pattern.step01beforeproxy.Hello;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * DynamicProxy - 동적 프록시?
 *
 * java.lang.reflect가 제공하는 InvocationHandler를 이용하여
 * 런타임 과정에서 프록시 객체를 동적으로 생성(Dynamic Proxy)
 */
public class UppercaseHandler implements InvocationHandler {

    Hello target;

    public UppercaseHandler(Hello target) {
        this.target = target;
    }

    /*
        프록시 객체가 클라이언트로부터 받는 모든 요청은 먼저 invoke()로 전달되며,
        결과적으로 프록시를 통해 요청이 전달되면 invoke() 내부에서는 리플렉션 API(Method method)를 통해
        타겟 객체의 메서드를 호출함
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String delegation = (String) method.invoke(target, args);
        String uppercased = delegation.toUpperCase();

        return uppercased;
    }
}
