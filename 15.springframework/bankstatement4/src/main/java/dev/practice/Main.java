package dev.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		final ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		final Vehicle vehicle = context.getBean(Vehicle.class);
		vehicle.ride();
	}
}
