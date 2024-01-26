package dev.bank.bankstatement.service;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import dev.bank.bankstatement.domain.BankTransaction;

//입출금 관련 도메인(비즈니스) 로직을 처리하는 클래스
public class BankStatementProcessor {
	private final List<BankTransaction> bankTransactions; // 추후 모든 연산에서 입출금 내역 목록을 사용할 것이기 때문에 클래스의 필드로 설정

	public BankStatementProcessor(List<BankTransaction> bankTransactions) {
		this.bankTransactions = bankTransactions;
	}
	
	// BankStatementAnlyzerWithProcessor.java에서 분리시키기 위해 옮긴 메서드(하단 메서드들도 동일)
	public double calculateTotalAmount() {
		double total = 0d;
		for (BankTransaction bankTransaction : bankTransactions) {
			total += bankTransaction.getAmount();
		}
		return total;
	}

	// selectInMonth() 에서 calculateTotalInMonth()로 메서드명 변경
	public List<BankTransaction> calculateTotalInMonth(Month month) {
		final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
		for (BankTransaction bankTransaction : bankTransactions) {
			if (bankTransaction.getDate().getMonth() == month)
				bankTransactionsInMonth.add(bankTransaction);
		}
		return bankTransactionsInMonth;
	}
	
	// 카테고리 별로 조회할 수 있는 메서드 추가
	public double calculateTotalForCategory(String category) {
		double total = 0;
		for (BankTransaction bankTransaction : bankTransactions) {
			if(bankTransaction.getDescription().equals(category)) total += bankTransaction.getAmount();
		}
		return total;
	}

}