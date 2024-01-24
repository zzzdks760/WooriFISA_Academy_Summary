package dev.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.jpa.model.Car;

public class Step99Practice {
	public static void main(String[] args) {
//		persistence.xml 기반으로 생성, JPA는 인터페이스이고 EntityManagerFactory는 구현체이다.
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("step02jpabasic");
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		try {
			transaction.begin(); // 트랜잭션 시작!
			
			Car car = new Car("벤츠", "s클래스", "대형 세단", 147800000);
			Car car2 = new Car("벤츠", "e클래스", "준대형 세단", 70500000);
			Car car3 = new Car("제네시스", "G80", "준대형 세단", 58900000);
			Car car4 = new Car("제네시스", "GV80", "준대형 SUV", 69300000);
			
			em.persist(car);
			em.persist(car2);
			em.persist(car3);
			em.persist(car4);
			
			transaction.commit(); // flush를 통해 DB에 INSERT 트랜잭션 종료! flush는 rollback가능 commit은 불가능
		} catch (Exception e) {
			
		} finally {
			factory.close(); // 자원 반납
		}
	}
}
