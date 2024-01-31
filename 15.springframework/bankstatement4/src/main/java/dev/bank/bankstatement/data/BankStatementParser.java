package dev.bank.bankstatement.data;

import java.util.List;

import dev.bank.bankstatement.domain.BankTransaction;

public interface BankStatementParser {
	BankTransaction parseFrom(String line);
	List<BankTransaction> parseLinesFrom(List<String> lines);
}
