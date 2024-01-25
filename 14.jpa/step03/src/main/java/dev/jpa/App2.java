package dev.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.jpa.model.Major;
import dev.jpa.model.Student;

public class App2 {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("step03");
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		Student student = new Student("남혁");
		Major major = new Major("수학과");
		
		try {
			transaction.begin();
			
			em.persist(student);
			em.persist(major);
			
			transaction.commit();
			
			transaction.begin();
			
			Student findStudent = em.find(Student.class, 1);
			Major findMajor = em.find(Major.class, 1);
			System.out.println(findStudent.getName() + " " + findMajor.getName());
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
		
		
		
		
	}

}
