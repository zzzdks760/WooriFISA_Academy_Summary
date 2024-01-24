package dev.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


/**
 * 1. EntityManagerFactory - 2차 캐시, 커넥션 풀, 트랜잭션 처리 등과 같은 각 Session에서 사용되는 서비스들을 유지, 관리하는 역할
 * 
 * 2. EntityManager
 * 	- 하나의 작업 단위(Unit of Work)를 모델링한 싱글 스레드 객체
 *  - 영속성 컨텍스트에 접근하여 엔티티들을 관리하는 역할
 *  - JDBC의 Connection 객체를 래핑(Wrapping)
 *  - EntityTransaction 객체를 생성할 수 있는 Factory 역할
 *  
 *3. EntityTransaction
 *  - 개별적인 트랜잭션 범위(경계) 설정, 처리를 위한 객체
 *  - JDBC 혹은 JTA(Java Transaction API)의 트랜잭션 처리를 추상화한 API 
 */
public class Step02CreatingEntityManager {
	public static void main(String[] args) {
//		persistence.xml 기반으로 생성, JPA는 인터페이스이고 EntityManagerFactory는 구현체이다.
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("step02jpabasic");
		System.out.println(factory);
		
		EntityManager em = factory.createEntityManager();
		System.out.println(em);
		
		EntityTransaction transaction = em.getTransaction();
		System.out.println(transaction);
	}
}
