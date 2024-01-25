package dev.jpa;

import dev.jpa.model.Major;
import dev.jpa.model.Student;

public class App {

	public static void main(String[] args) {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("step03");
//		System.out.println(factory);
		
		Student kim = new Student("남혁");
		Major major = new Major("수학과");
		
		kim.setMajor(major);
		
		System.out.println(kim.getMajor());
		
		Student sungmin = new Student("성민");
		Major major2 = new Major("소프트웨어");
		
		sungmin.setMajor(major2);
		
		System.out.println(sungmin.getMajor());
	}

}
