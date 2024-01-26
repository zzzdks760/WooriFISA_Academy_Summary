package dev.spring.step01setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 내 방
 * 
 * 비디오 테이프를 빌렸는데, 내 방에서 비디오 테이프(Tape)가 잘 돌아가는지 테스트
 * 
 * 비디오 테스트 기기인 TapeReader가 할 수 있음
 */
public class MyRoom {

	public static void main(String[] args) {
		
//		설정 파일이 XML파일이고, 해당 파일을 기반으로 컨텍스트를 구성
//		ApplicationContext context = new ClassPathXmlApplicationContext("setter-config.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("constructor-config.xml");
		
		Tape tape = (Tape) context.getBean("tape");
		System.out.println(tape);
		
		TapeReader reader = (TapeReader)context.getBean("tapeReader");
		reader.test();
		
	}

}
