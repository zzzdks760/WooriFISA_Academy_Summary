package dev.bank.bankstatement;

import dev.bank.bankstatement.data.BankStatementCSVParser;
import dev.bank.bankstatement.data.BankStatementTSVParser;

public class BankStatementFactory {
	public BankStatementCSVParser createCSVParser() {
		return new BankStatementCSVParser();
	}
	
	public BankStatementTSVParser createTSVParser() {
		return new BankStatementTSVParser();
	}
}
