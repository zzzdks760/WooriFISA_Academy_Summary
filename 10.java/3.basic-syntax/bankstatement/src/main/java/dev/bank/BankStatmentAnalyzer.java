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
import dev.bank.parser.BankStatementTSVParser;

public class BankStatmentAnalyzer {
	private static final String RESOURCES = "src/main/resources/";

	public static void main(String[] args) {
		// 1. 첫 번째 관심사 - 주어진 입출금 내역 파일(TSV) 읽기
		final Path path = Paths.get(RESOURCES + "bank-data.txt");

		try {
			List<String> lines = Files.readAllLines(path);

			// 2. 두 번째 관심사 - 읽어들인 데이터 파싱 처리
			BankStatementTSVParser tsvParser = new BankStatementTSVParser();
			List<BankTransaction> bankTransactions = tsvParser.parseLinesFromTSV(lines);

			// 3. 세 번째 관심사 - 연산 처리 및 연산 결과 출력
			BankStatementProcessor bankStatementProcessor = new BankStatementProcessor();
			String calculateTotalAmount = bankStatementProcessor.calculateTotalAmount(bankTransactions);
			String calculateTotalInMonth = bankStatementProcessor.calculateTotalInMonth(bankTransactions, Month.FEBRUARY);
			System.out.println(calculateTotalAmount);
			System.out.println(calculateTotalInMonth);
//			String result = String.format("총 입출금액은 %.2f원입니다.", bankStatementProcessor.calculateTotalAmount(bankTransactions));
//			System.out.println(result);

//			String resultForMonth = String.format("2월의 입출금액은 %.2f원 입니다.", bankStatementProcessor.calculateTotalInMonth(bankTransactions, Month.FEBRUARY));
//			System.out.println(resultForMonth);

		} catch (IOException e) {
			e.printStackTrace(); // 예외가 발생한 내역(스택) 추적해서 출력해
		}
	}

//	// 총 입출금액 조회
//	private static double calculateTotalAmount(List<BankTransaction> bankTransactions) {
//		double total = 0d;
//		
//		for (BankTransaction bankTransaction : bankTransactions) {
//			total += bankTransaction.getAmount();
//		}
//		
//		return total;
//	}
//
//	// 특정 월의 입출금액 조회 로직으로 개선
//	private static double calculateTotalInMonth(List<BankTransaction> bankTransactions, Month month) {
//		double total = 0d;
//
//		for (BankTransaction bankTransaction : bankTransactions) {
//			if (bankTransaction.getDate().getMonth() == month)
//				total += bankTransaction.getAmount();
//		}
//		
//		return total;
//	}

}