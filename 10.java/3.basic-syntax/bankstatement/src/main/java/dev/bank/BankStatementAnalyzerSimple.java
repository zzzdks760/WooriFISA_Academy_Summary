package dev.bank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BankStatementAnalyzerSimple {
	private static final String RESOURCES = "src/main/resources/";
	private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");

	public static void main(String[] args) {
		// 입출금 데이터(bank-data.csv) 읽기
		final Path path = Paths.get(RESOURCES + "bank-data.csv");
		
		try {
			// List<String> lines에서 lines는 문자열 타입만 들어올 수 있는 가변 배열
			List<String> lines = Files.readAllLines(path);
			
			// 입출금 내역 데이터가 비어있을 경우, ex) empty-bank-data.csv
			// "입출금 내역이 하나도 없습니다." 후 프로그램 종료
			if(lines.isEmpty()) {
				System.out.println("입출금 내역이 없는뎁쇼?");
				return;
			}
			
			// 전체 입출금액 조회
			long total = 0L; // 총 입출금액
			for (String line : lines) {
				String[] columns = line.split(",");
				long amount = Long.parseLong(columns[2]); // Type mismatch: cannot convert from String to long
				total += amount;
			}

			// 연산 결과 출력
			String result = String.format("총 입출금액은 %d원입니다.", total);
			System.out.println(result);
			
			// 2월의 입출금액 조회 로직 작성
			long totalForMonth = 0L;
			for (String line : lines) {
                final String[] columns = line.split(",");
                final LocalDateTime dateTime = LocalDateTime.parse(columns[0], DATE_PATTERN);
//				System.out.println(dateTime); // getMonth(), getMinute() ...

                if (dateTime.getMonth() == Month.FEBRUARY) {
                    totalForMonth += Long.parseLong(columns[2]);
                }
            }
			
			String resultForMonth = String.format("2월의 입출금액은 %d원 입니다.", totalForMonth);
            System.out.println(resultForMonth);
            
		} catch (IOException e) {
			e.printStackTrace(); // 예외가 발생한 내역(스택) 추적해서 출력해
		}
	}

}