package dev.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.jpa.model.Book;

public class Step05UpdateEntity {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("step02jpabasic");
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		try {
			transaction.begin();
			
			Book book = em.find(Book.class, 1);
			book.setName("김영한의 JPA");
			book.setAuthor("김영한");
			
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

}
