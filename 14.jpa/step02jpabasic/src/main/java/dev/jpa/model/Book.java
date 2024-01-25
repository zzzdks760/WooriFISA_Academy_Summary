package dev.jpa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Book {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "book_name", nullable = false)
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	// TemporalType.DATE : 날짜, DB date 타입과 맵핑(ex. 2022-03-03)
    // TemporalType.TIME : 시간, DB time 타입과 맵핑(ex. 09:30:23)
    // TemporalType.TIMESTAMP : 날짜와 시간, DB timestamp 타입과 매핑(ex. 2022-12-23 09:53:24)
	@Column(name = "pub_date")
	private Date pubDate; // java.util.Date
	
	private String author;

	protected Book() {}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public Book(String name, String author) {
		this.name = name;
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", pubDate=" + pubDate + ", author=" + author + "]";
	}

}
