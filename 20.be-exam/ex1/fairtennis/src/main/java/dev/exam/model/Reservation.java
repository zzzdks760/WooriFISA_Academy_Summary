package dev.exam.model;

import java.time.LocalDateTime;

public class Reservation {
	private long id;
	private String centerName;
	private int courtNumber;
	private LocalDateTime reservedTime;

	public Reservation(String centerName, int courtNumber, LocalDateTime reservedTime) {
		super();
		this.id = System.nanoTime();
		this.centerName = centerName;
		this.courtNumber = courtNumber;
		this.reservedTime = reservedTime;
	}

	public long getId() {
		return id;
	}

	public String getCenterName() {
		return centerName;
	}

	public int getCourtNumber() {
		return courtNumber;
	}

	public LocalDateTime getReservedTime() {
		return reservedTime;
	}

}