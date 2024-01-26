package dev.starbar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	private String id;
	
	@Column(nullable = false)
	private String password;
	
	public String getUserId() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}

	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
}
