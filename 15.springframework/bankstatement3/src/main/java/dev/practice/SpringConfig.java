package dev.practice;

import org.springframework.context.annotation.Bean;

public class SpringConfig {
	@Bean
	public Car createCar() {
		return new Car();
	}
	
	@Bean
	public Airplane createAirplane() {
		return new Airplane();
	}
	
	@Bean
	public Metro createMetro() {
		return new Metro();
	}
}
