package dev.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyRoom {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfigWithComponentScan.class);
		
		TapeReader reader = ctx.getBean(TapeReader.class);
		
		System.out.println(reader);
		
		reader.test();
	}

}
