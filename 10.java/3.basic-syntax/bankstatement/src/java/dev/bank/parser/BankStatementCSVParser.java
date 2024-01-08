package dev.bank.parser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dev.bank.model.BankTransaction;

public class BankStatementCSVParser implements BankStatementParser{
	final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
	
	// 메서드
		// 1. 데이터에서 한 줄만 파싱하는 기능
		public BankTransaction parseFrom(final String line) {
			String[] columns = line.split(",");
			LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
			String description = columns[1]; // 거래처 데이터 파싱
			double amount = Double.parseDouble(columns[2]);

			BankTransaction bankTransaction = new BankTransaction(date, description, amount);
			return bankTransaction;
		}
		
		// 2. 한줄씩 파싱된 데이터를 리스트에 추가하는 기능
		public List<BankTransaction> parseLinesFrom(List<String> lines) {
			List<BankTransaction> bankTransactions = new ArrayList<>();
			
			for (String line : lines) {
				BankTransaction bankTransaction = parseFrom(line);
				bankTransactions.add(bankTransaction);
			}
			
			return bankTransactions;
		}
}
