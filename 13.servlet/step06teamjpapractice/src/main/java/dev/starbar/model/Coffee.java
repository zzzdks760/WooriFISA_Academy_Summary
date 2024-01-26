package dev.starbar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Coffee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String size;
	
	@Column(nullable = false)
	private int price;
	
	@ManyToOne
	private Bean bean;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSize() {
		return size;
	}
	public int getPrice() {
		return price;
	}
	
	public Coffee(int id, String name, String size, int price) {
		this.id = id;
		this.name = name;
		this.size = size;
		this.price = price;
	}
	
	public Coffee(String name, String size, int price) {
		this.name = name;
		this.size = size;
		this.price = price;
	}
	
}