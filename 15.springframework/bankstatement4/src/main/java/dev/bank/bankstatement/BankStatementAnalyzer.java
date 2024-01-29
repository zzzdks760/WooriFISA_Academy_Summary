package dev.bank.bankstatement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Component;

import dev.bank.bankstatement.data.BankStatementParser;
import dev.bank.bankstatement.domain.BankTransaction;
import dev.bank.bankstatement.service.BankStatementProcessor;

public class BankStatementAnalyzer {

	private static final String RESOURCES = "src/main/resources/";

	public void analyze(String fileName, BankStatementParser bankStatementParser) throws IOException {
		final Path path = Paths.get(RESOURCES + fileName);
		final List<String> lines = Files.readAllLines(path);
		
		List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
		
		final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

		collectSummary(bankStatementProcessor);
	}
	
	private static void collectSummary(BankStatementProcessor bankStatementProcessor) {
		System.out.println("총 입출금 내역은 " + bankStatementProcessor.calculateTotalAmount());
		
		System.out.println("1월의 입출금 내역은 " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
		
		System.out.println("Salary(급여) 카테고리의 내역은 " + bankStatementProcessor.calculateTotalForCategory("Salary"));
	}

}