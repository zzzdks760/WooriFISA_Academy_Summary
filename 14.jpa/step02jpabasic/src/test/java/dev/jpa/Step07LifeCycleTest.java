package dev.jpa;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import dev.jpa.model.Book;

class Step07LifeCycleTest {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("step02jpabasic");
	EntityManager em = factory.createEntityManager();
	EntityTransaction transaction = em.getTransaction();
	
	@Test
	void testPersist를_수행할_경우_엔티티가_영속화되고_commit이_수행될_경우_DB에_저장된다() {
		transaction.begin();
		
		Book book = new Book("JPA", "김남혁");
		em.persist(book);
		
		Book findBook = em.find(Book.class, book.getId());
		assertEquals(book, findBook);
		transaction.commit();
//		transaction.rollback();
	}
	
	@Test
	void test한번_영속화된_엔티티는_다시_조회시_DB가_아닌_영속성컨텍스트에서_조회된다() {
		
		Book findBook = em.find(Book.class, 1);
		System.out.println(findBook);
		
		Book findBook2 = em.find(Book.class, 1);
		assertEquals(findBook, findBook2);
	}

	@Test
	void test엔티티의_값을_수정하고_commit하면_변경감지가_발생되어_UPDATE쿼리가_수행된다() {
		transaction.begin();
		
		Book findBook = em.find(Book.class, 1);
		findBook.setName("JAVA");
		
		transaction.commit();
		assertEquals(findBook.getName(), "JAVA");
	}

	@Test
	void test만약_엔티티를_detach할경우_필드의_값을_변경해도_UPDATE쿼리가_수행되지_않는다() {
		transaction.begin();
		
		Book findBook = em.find(Book.class, 3);
		findBook.setAuthor("남궁성");
		
		em.detach(findBook);
		
		transaction.commit();
		
		Book updateBook = em.find(Book.class, 3);
		assertEquals("김영한", updateBook.getAuthor());
	}

	@Test
	void testRemove를_수행할경우_PC와_DB에서_데이터가_제거된다() {
		transaction.begin();
		
		Book findBook = em.find(Book.class, 10);
		em.remove(findBook);
		
		transaction.commit();
		
		assertFalse(em.contains(findBook));
	}

	@Test
	void test영속성컨텍스트를_초기화할경우_모든_엔티티가_제거됨() {
		Book findBook = em.find(Book.class, 1);
		
		em.clear();
		
		Book detachedBook = em.find(Book.class, 1);
		
		assertFalse(findBook == detachedBook);
	}

	@Test
	void test엔티티매니저가_제거됨() {
		EntityManager beforeClose = em;
		System.out.println(beforeClose);
		
		em.close();
		
		EntityManager afterClose = em;
		System.out.println(afterClose);
		
		assertEquals(beforeClose, afterClose);
	}

}
