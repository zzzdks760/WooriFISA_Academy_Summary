package dev.practice;

import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle{

	@Override
	public void ride() {
		System.out.println("자동차 탑승!");
	}
	
}
