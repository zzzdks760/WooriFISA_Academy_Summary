package dev.bank.bankstatement.data;

import java.util.List;

import org.springframework.stereotype.Component;

import dev.bank.bankstatement.domain.BankTransaction;

@Component
public interface BankStatementParser {
	BankTransaction parseFrom(String line);
	List<BankTransaction> parseLinesFrom(List<String> lines);
}
