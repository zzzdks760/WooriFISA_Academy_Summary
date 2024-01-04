package dev.bank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

import dev.bank.model.BankTransaction;
import dev.bank.parser.BankStatementCSVParser;
import dev.bank.parser.BankStatementTSVParser;

public class BankStatmentAnalyzer {
	private static final String RESOURCES = "src/main/resources/";

	public static void main(String[] args) {
		// 1. 첫 번째 관심사 - 주어진 입출금 내역 파일(TSV) 읽기
		final Path path = Paths.get(RESOURCES + "bank-data.csv");

		try {
			List<String> lines = Files.readAllLines(path);

			// 2. 두 번째 관심사 - 읽어들인 데이터 파싱 처리
//			BankStatementTSVParser tsvParser = new BankStatementTSVParser();
//			List<BankTransaction> bankTransactions = tsvParser.parseLinesFromTSV(lines);
			
			BankStatementCSVParser csvParser = new BankStatementCSVParser();
			List<BankTransaction> bankTransactions = csvParser.parseLinesFromCSV(lines);

			// 3. 세 번째 관심사 - 연산 처리 및 연산 결과 출력
			BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
			String totalResult = bankStatementProcessor.calculateTotalAmount();
			String totalMonthResult = bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY);
			System.out.println(totalResult);
			System.out.println(totalMonthResult);

		} catch (IOException e) {
			e.printStackTrace(); // 예외가 발생한 내역(스택) 추적해서 출력해
		}
	}
	
	// 카테고리(거래처, description)별로 입출금 내역을 조회할 수 있는 메서드

}