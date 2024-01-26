package dev.starbar.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.starbar.model.User;

public class UserDAO {
	
	private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("step06teamjpapractice");
	private final EntityManager em = factory.createEntityManager();
	private final EntityTransaction transaction = em.getTransaction();
	
	/**
	 * 회원가입
	 */
	public boolean save(String id, String password) {

		try {
			transaction.begin();
			
			User user = new User(id, password);
			em.persist(user);
			
			transaction.commit();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 로그인
	 */
	public boolean findUser(String id, String password) {
		try {
			User user = em.createQuery("SELECT u FROM User u where u.id = :id AND u.password = :password", User.class)
					.setParameter("id", id)
					.setParameter("password", password)
					.getSingleResult();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}