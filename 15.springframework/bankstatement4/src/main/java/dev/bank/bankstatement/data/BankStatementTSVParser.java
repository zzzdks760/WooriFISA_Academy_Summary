package dev.bank.bankstatement.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import dev.bank.bankstatement.domain.BankTransaction;

@Component
public class BankStatementTSVParser implements BankStatementParser{
	private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	public BankTransaction parseFrom(final String line) {
		String[] columns = line.split("\t");

		LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
		double amount = Double.parseDouble(columns[1]);
		final String description = columns[2];

		return new BankTransaction(date, amount, description);
	}

	public List<BankTransaction> parseLinesFrom(List<String> lines) {
		List<BankTransaction> bankTransactions = new ArrayList<>();

		for (String line : lines) {
			bankTransactions.add(parseFrom(line));
		}

		return bankTransactions;
	}

}
