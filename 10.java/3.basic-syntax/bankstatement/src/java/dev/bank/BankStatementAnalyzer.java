package dev.bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import dev.bank.model.BankTransaction;
import dev.bank.parser.BankStatementCSVParser;
import dev.bank.parser.BankStatementParser;
import dev.bank.parser.BankStatementTSVParser;

public class BankStatementAnalyzer {
//	private static final String RESOURCES = "src/main/resources/";

	// jar 실행용
	private static final String RESOURCES = "/resources/";
	
	public void analyze(final String fileName) {

		// 1. 첫 번째 관심사 - 주어진 입출금 내역 파일 읽기
		List<String> lines = new ArrayList<>();

		try (InputStream inputStream = MainApplication.class.getResourceAsStream(RESOURCES + fileName);
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		BankStatementParser parser = null;
		if (fileName.contains(".csv")) {
			parser = new BankStatementCSVParser();
		} else if (fileName.contains(".txt")) {
			parser = new BankStatementTSVParser();
		} else {
			System.out.println("올바른 파일 확장자를 선택하세요.");
			return;
		}

		// 2. 두 번째 관심사 - 읽어들인 데이터 파싱 처리
		List<BankTransaction> bankTransactions = parser.parseLinesFrom(lines);

		// 3. 세 번째 관심사 - 연산 처리 및 연산 결과 출력
		BankStatementProcessor processor = new BankStatementProcessor(bankTransactions);
		String result = processor.calculateTotalAmount();
		
		System.out.println(result);

		String resultForMonth = processor.calculateTotalInMonth(Month.FEBRUARY);
		System.out.println(resultForMonth);
		
		}
}
