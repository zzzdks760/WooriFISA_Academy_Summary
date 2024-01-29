package dev.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyRoom {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("component-scan-config.xml");
		
		TapeReader reader = ctx.getBean(TapeReader.class);
		
		System.out.println(reader);
		
		reader.test();
	}

}
