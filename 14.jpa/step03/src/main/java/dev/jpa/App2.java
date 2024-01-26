package dev.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dev.jpa.model.Major;
import dev.jpa.model.Student;

public class App2 {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("step03");
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		
		try {

			 List<Student> resultList = em.createQuery("SELECT s FROM Student s",Student.class).getResultList();

			 System.out.println(resultList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
		
		
		
		
	}

}
