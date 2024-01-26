package dev.bank.bankstatement;

import java.io.IOException;

import dev.bank.bankstatement.data.BankStatementCSVParser;
import dev.bank.bankstatement.data.BankStatementParser;

public class MainApplication {

	public static void main(String[] args) throws IOException {
		final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
		
		final BankStatementParser bankStatementParser = new BankStatementCSVParser(); // or new BankStatementTSVParser();
		
		bankStatementAnalyzer.analyze("bank-data-simple.csv", bankStatementParser);
	}

}
