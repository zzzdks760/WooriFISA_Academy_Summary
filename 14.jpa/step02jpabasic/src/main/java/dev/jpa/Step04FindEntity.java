package dev.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.jpa.model.Book;

public class Step04FindEntity {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("step02jpabasic");
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		try {
			// 아이디가 1번인 Book 객체 조회
			Book book = em.find(Book.class, 1);
			System.out.println(book);
			
		} catch (Exception e) {
			
		} finally {
			
		}
	}
}
