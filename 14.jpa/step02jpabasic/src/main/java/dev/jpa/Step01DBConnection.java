package dev.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * JPA를 쓰려면 사용하려는 DBMS와 연결하는 설정 작업
 * 
 * 1-1. JPA의존성 설치
 * JPA 구현체 - Hibernate
 * 
 * 1-2. JPA가 DB 설정파일을 읽도록 내용 작성 및 경로 지정
 */
public class Step01DBConnection {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("step02jpabasic");
		System.out.println(factory);
		
		while (true) {}
	}

}
