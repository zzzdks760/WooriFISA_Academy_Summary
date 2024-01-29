package dev.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component // 스프링의 컴포넌트 스캔 대상이 되어 컨테이너가 관리하는 Bean으로 등록
public class Tape {
	
	private String name; // 필드 기반으로 기본 값 지정
	private boolean isWorked; // true, false 바꿔보기

	public Tape(@Value("아일랜드") String name, @Value("true") boolean isWorked) {
		super();
		this.name = name;
		this.isWorked = isWorked;
		System.out.println("Tape 생성자 호출");
	}

	public String getName() {
		System.out.println("getName 호출");
		return name;
	}

	public void setName(String name) {
		System.out.println("setName(String name) called()");
		System.out.println("setName 호출");
		this.name = name;
	}

	public boolean isWorked() {
		System.out.println("isWorked 호출");
		return isWorked;
	}

	public void setWorked(boolean isWorked) {
		System.out.println("setWorked 호출");
		this.isWorked = isWorked;
	}

	@Override
	public String toString() {
		return "Tape [name=" + name + ", isWorked=" + isWorked + "]";
	}

}