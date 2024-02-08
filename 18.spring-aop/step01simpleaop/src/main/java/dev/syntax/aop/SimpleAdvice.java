package dev.syntax.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

@Slf4j
public class SimpleAdvice implements MethodBeforeAdvice, AfterReturningAdvice {
    // MethodBeforeAdvice - 대상 메서드(Target Method)인 UserController의 getUsers()같은 메서드가
    // 실제로 호출되기 전에 미리 처리할 내용을 작성할 수 있도록 기능을 제공하는 인터페이스

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        // Method - 대상 클래스가 가진 메서드의 메타 정보를 취득할 수 있는 객체
        log.info("-- before: {}", method);
    }

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        log.info("-- after: {}", method);
    }
}
