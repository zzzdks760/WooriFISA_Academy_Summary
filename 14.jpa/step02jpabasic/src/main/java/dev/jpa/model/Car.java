package dev.jpa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Car {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_id")
	private int id;
	
	@Column(name = "car_brand", nullable = false)
	private String brand;
	
	@Column(name = "car_name", nullable = false)
	private String name;
	
	@Column(name = "car_type", nullable = false, length = 30)
	private String type;
	
	@Column(name = "car_price", nullable = false)
	private int price;
	
	@CreationTimestamp
	@Column(name = "create_date")
	private Date createDate;
	
	@UpdateTimestamp
	@Column(name = "update_date")
	private Date updateDate;

	public Car(String brand, String name, String type, int price) {
		this.brand = brand;
		this.name = name;
		this.type = type;
		this.price = price;
	}
	
}
