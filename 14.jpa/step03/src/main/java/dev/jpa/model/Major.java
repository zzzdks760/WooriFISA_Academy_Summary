package dev.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Major {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MAJOR_ID")
	private int id;
	
	@Column(name = "MAJOR_NAME")
	private String name;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Major(String name) {
		this.name = name;
	}

	protected Major() {
	}

	@Override
	public String toString() {
		return "Major [id=" + id + ", name=" + name + "]";
	}
	
	
}
