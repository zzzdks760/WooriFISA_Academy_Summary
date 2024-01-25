package dev.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Student {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STUDENT_ID")
	private int id;
	
	@Column(name = "STUDENT_NAME")
	private String name;
	
	@ManyToOne
	private Major major;
	
	public Student(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}
	
	public int getId() {
		return id;
	}

	protected Student() {
	}

	@Override
	public String toString() {
		return "Student [major=" + major + ", id=" + id + ", name=" + name + "]";
	}
	
}
