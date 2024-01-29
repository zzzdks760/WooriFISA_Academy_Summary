package dev.spring.step01field;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyRoom {

	public static void main(String[] args) {
		
		// 1. 아직은 XML파일을 사용하지만, Annotation이 적용되어 보다 간소화된 설정 방식
		
		// step01field에서는 필드(field) 기반으로 의존성 주입
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("annotation-config-field.xml");
		
		TapeReader reader = context.getBean(TapeReader.class);
		reader.test();
		
		((ClassPathXmlApplicationContext) context).close();
	}

}
