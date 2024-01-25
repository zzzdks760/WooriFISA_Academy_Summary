package dev.jpa;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dev.jpa.model.Major;
import dev.jpa.model.Student;

class MappingTest {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("step03");
	EntityManager em = factory.createEntityManager();
	EntityTransaction transaction = em.getTransaction();
	
	@AfterEach
	void rollBack() {
//		transaction.rollback();
	}

	// 엔티티 저장
	@Test
	@DisplayName("엔티티 저장 테스트")
	void testSave() {
		/**
		 * 학과 1개 생성
		 * 학생 2명 생성
		 * 
		 * 생성한 학생에게 학과 설정 후에 영속화 및 MySQL CLI에서 결과 조회 
		 */
		Major major = new Major("컴공과");
		Student student = new Student("남혁");
		Student student2 = new Student("성민");
		
		transaction.begin();
		em.persist(student);
		em.persist(student2);
		em.persist(major);
		
		student.setMajor(major);
		student2.setMajor(major);
		
		transaction.commit();
		
		Student findStudent = em.find(Student.class, student.getId());
		Student findStudent2 = em.find(Student.class, student2.getId());
		
		
		assertEquals(findStudent.getMajor().getId(), findStudent2.getMajor().getId());
	}
	
	@Test
	@DisplayName("엔티티 조회 테스트")
	void testRead() {
		/**
		 * 학생 1명 조회 후 해당 학생의 전공이 무엇인지 조회
		 */
		
		Student findStudent = em.find(Student.class, 1);
		
		assertEquals(findStudent.getMajor().getName(), "컴공과");
	}
	
	@Test
	@DisplayName("연관관계 필드 값 업데이트 테스트")
	void testUpdateEntity() {
		/**
		 * 학생 1명 조회 후에 해당 학생의 전공을 다른 전공으로 변경(전과 처리)
		 * (다른 전공 객체를 생성)
		 */
		Major major = new Major("수학과");
		Student findStudent = em.find(Student.class, 1);
		
		transaction.begin();
		em.persist(major);
		
		findStudent.setMajor(major);
		
		Student findStudent2 = em.find(Student.class, 1);
		
		transaction.commit();
	
		assertEquals(findStudent2.getMajor().getName(), "수학과");
	}
	
	@Test
	@DisplayName("연관관계 엔티티 제거 테스트")
	void testDeleteEntity() {
		/**
		 * 특정 학생의 전공 제거(학과에서 제적 처리)
		 */
		transaction.begin();
		Student findStudent = em.find(Student.class, 1);
		Major major = findStudent.getMajor();
		em.remove(major);
		transaction.commit();
		assertFalse(em.contains(major));
	}
	
	@Test
	@DisplayName("어떤 학과의 학생이 몇명, 누가 있는지 조회 테스트(양방향 맵핑)")
	void testReverse() {
		em.createQuery("SELECT m.MAJOR_NAME, s.STUDENT_NAME FROM student s JOIN major m ON ")
	}
}
