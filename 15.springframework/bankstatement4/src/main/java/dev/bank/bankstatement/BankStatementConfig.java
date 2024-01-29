package dev.bank.bankstatement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.bank.bankstatement.data.BankStatementCSVParser;
import dev.bank.bankstatement.data.BankStatementTSVParser;

public class BankStatementConfig {
	@Bean
	public BankStatementCSVParser createCSVParser() {
		return new BankStatementCSVParser();
	}
	
	@Bean
	public BankStatementTSVParser createTSVParser() {
		return new BankStatementTSVParser();
	}
}
