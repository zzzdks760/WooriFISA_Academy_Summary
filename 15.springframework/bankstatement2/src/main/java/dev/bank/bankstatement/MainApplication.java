package dev.bank.bankstatement;

import java.io.IOException;

import dev.bank.bankstatement.data.BankStatementCSVParser;
import dev.bank.bankstatement.data.BankStatementParser;
import dev.bank.bankstatement.data.BankStatementTSVParser;

public class MainApplication {

	public static void main(String[] args) throws IOException {
		final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
		
		final BankStatementFactory factory = new BankStatementFactory();
		
		final BankStatementParser bankStatementParser =  factory.createCSVParser(); // or new BankStatementTSVParser();
		
		bankStatementAnalyzer.analyze("bank-data-simple.csv", bankStatementParser);
	}

}
