package dev.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.jpa.model.Book;
import dev.jpa.model.Car;

/**
 * Persist - 영속화
 */


/**
 * JPA의 기본 키 생성 전략
 * 1. 직접 할당 : 기본 키를 애플리케이션에서 직접 할당
 * 2. 자동 생성 : 대리 키 사용 방식
 *  1) IDENTITY : 기본 키 생성을 DB에 위임.(MySQL의 auto_increment 방식)
 *  2) SEQUENCE : DB 시퀀스를 사용해서 기본키 할당(오라클은 지원하나, MySQL은 미지원)
 *  3) TABLE : 키 생성 테이블을 사용(키 생성용 별도의 테이블을 생성하고, 시퀀스처럼 사용하는 방식, 테이블을 사용하므로 모든 DB에서 사용 가능.)
 * 
 * 직접 할당 방식을 사용하려면 @Id만 쓰면 되고,
 * 자동 생성 전략을 사용하려면 @Id에 @GeneratedValue를 추가하고 원하는 키 생성 전략을 선택하면 됨.
 * 
 * 직접 할당 방식 예.
 * Book book = new Book();
 * book.setId("book1");
 * 
 * 1. Id 어노테이션
 * DB 테이블의 PK와 매핑, 이 Entity로부터 생성된 객체는 다른 객체와 식별하는 부분에서 사용됨.
 * 또한 테이블의 기본키(PK)로도 사용됨
 * 
 * 2. GeneratedValue 어노테이션
 * 식별자 값 자동 증가 설정, strategy : 자동 생성 전략 사용(GenerationType 지정) / generator(이미 생성된 키 생성기 참조 ex) sequence generator) 
 * GenerationType.TABLE : 테이블을 사용하여 PK값 생성, PK값 생성만을 위한 별도의 테이블 필요.
 * GenerationType.SEQUENCE : 시퀀스를 이용하여 PK값 생성, 시퀀스를 지원하는 DB에서만 사용 가능
 * GenerationType.IDENTITY : auto_increment나 IDENTITY를 이용하여 PK값 생성, MySQL에서 주로 사용
 * GenerationType.AUTO : DB에 맞는 PK값 생성전략 선택(@GeneratedValue만 쓸 경우, Auto가 기본값으로 사용됨)
 */
public class Step03DoPersist {
	public static void main(String[] args) {
//		persistence.xml 기반으로 생성, JPA는 인터페이스이고 EntityManagerFactory는 구현체이다.
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("step02jpabasic");
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		try {
			transaction.begin(); // 트랜잭션 시작!
			
			Book book = new Book("어린왕자", "생택쥐페리");
			Book book2 = new Book("햄릿", "셰익스피어");
			
			em.persist(book); // 영속성 컨텍스트에 영속화
			em.persist(book2);
//			
			transaction.commit(); // flush를 통해 DB에 INSERT 트랜잭션 종료! flush는 rollback가능 commit은 불가능
		} catch (Exception e) {
			
		} finally {
			factory.close(); // 자원 반납
		}
	}
}
