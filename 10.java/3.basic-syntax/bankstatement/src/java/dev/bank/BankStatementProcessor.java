package dev.bank;

import java.time.Month;
import java.util.List;

import dev.bank.model.BankTransaction;

public class BankStatementProcessor {
	
	private List<BankTransaction> bankTransactions;
	
	public BankStatementProcessor(List<BankTransaction> bankTransactions) {
		this.bankTransactions = bankTransactions;
	}

	// 총 입출금액 조회
		public String calculateTotalAmount() {
			double total = 0d;
			
			for (BankTransaction bankTransaction : bankTransactions) {
				total += bankTransaction.getAmount();
			}
			
			return String.format("총 입출금액은 %.2f원입니다.", total);
		}

		// 특정 월의 입출금액 조회 로직으로 개선
		public String calculateTotalInMonth(Month month) {
			double total = 0d;

			for (BankTransaction bankTransaction : bankTransactions) {
				if (bankTransaction.getDate().getMonth() == month)
					total += bankTransaction.getAmount();
			}
			
			return String.format("2월의 입출금액은 %.2f원 입니다.", total);
		}
}
