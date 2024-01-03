package dev.bank.model;

import java.time.LocalDate;

public class BankTransaction {
	private LocalDate date; //입출금 날짜
	private double amount; //입출금 금액
	private String description; //거래처
	
	// 필드 초기화를 위한 생성자
	public BankTransaction(LocalDate date, String description, double amount) {
		this.date = date;
		this.description = description;
		this.amount = amount;
	}

	
	//그 외 getter, setter, toString() 등 필요에 따라
	public double getAmount() {
		return amount;
	}


	public LocalDate getDate() {
		return date;
	}
	
}
