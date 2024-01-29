package dev.summer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DrinkTest {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("dev.summer");

		Drink drink = context.getBean(Drink.class); // 컴포넌트 스캐닝 대상 패키지가 아니기 때문에 빈을 찾지 못함
		System.out.println(drink);
		
		((AnnotationConfigApplicationContext) context).close();
	}

}