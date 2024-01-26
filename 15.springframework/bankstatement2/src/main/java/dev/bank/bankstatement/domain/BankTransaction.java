package dev.bank.bankstatement.domain;

import java.time.LocalDate;

public class BankTransaction { 
	private LocalDate date;
	private double amount;
	private String description;

	public BankTransaction(LocalDate date, double amount, String description) {
		super();
		this.date = date;
		this.amount = amount;
		this.description = description;
	}

	public LocalDate getDate() {
		return date;
	}

	public double getAmount() {
		return amount;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "BankTransaction [date=" + date + ", amount=" + amount + ", description=" + description + "]";
	}

}