package dev.bank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class MainApplicationSimple {
	private static final String RESOURCES = "src/main/resources/";
	private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("yyyy-mm-ss");
	
	public static void main(String[] args) {	
		// 입출금 데이터(bank-date.csv) 읽기
		final Path path = Paths.get(RESOURCES + "bank-data.csv");
		System.out.println(path);
		
		try {
			List<String> lines = Files.readAllLines(path);
			
			if (lines.isEmpty()) {
				System.out.println("입출금 내역이 없습니다.");
				return;
			}
			//전체 입출금액 조회
			long total = 0L;
			
			//로직 작성
			for (String line : lines) {
				String[] columns = line.split(",");
				System.out.println(Arrays.toString(columns));
				long amount = Long.parseLong(columns[2]);
				total += amount;
			}
			
			
			String result = String.format("총 입출금액은 %d원입니다.", total);
			System.out.println(result);
			
			// 2월의 입출금액 조회 로직 작성
			long totalForMonth = 0L;
			
			for (String line : lines) {
				if (line.substring(5, 7).equals("02")) {
					String[] s = line.split(",");
					totalForMonth += Long.parseLong(s[2]);
				}
			}
			
			String resultForMonth = String.format("2월의 입출금액은 %d원 입니다.", totalForMonth);
			System.out.println(resultForMonth);
			
		} catch (IOException e) {
			e.printStackTrace(); // 예외가 발생한 내역(스택) 추적해서 출력해
		}
	}

}
