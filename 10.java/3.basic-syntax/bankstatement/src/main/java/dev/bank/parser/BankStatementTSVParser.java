package dev.bank.parser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dev.bank.model.BankTransaction;

// parser 패키지 - 데이터 변환 관련 처리 수행을 담당할 클래스들만 모아놓은 패키지
/**
 * 읽어들인 TSV(.txt) 파일을 Java 프로그램에서 사용할 수 있도록 변환 처리를 수행하는 클래스
 * @author Admin
 *
 */
public class BankStatementTSVParser {
	// 멤버 필드
	final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
	
	// 메서드
	// 1. 데이터에서 한 줄만 파싱하는 기능
	// 이 클래스 내에서만 사용할 메서드
	private BankTransaction parseFromTSV(final String line) {
		String[] columns = line.split(","); // tsv(Tab separated value), tab으로 구분된 파일
		LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN); // 문자열 -> 날짜 타입으로 파싱
		String description = columns[1]; // 거래처 데이터 파싱
		double amount = Double.parseDouble(columns[2]);

		// 파싱된 개별 타입의 값들을 BankTransaction이라는 클래스로 묶어줌(Wrapping)
		BankTransaction bankTransaction = new BankTransaction(date, description, amount);
		return bankTransaction;
	}
	
	// 2. 한줄씩 파싱된 데이터를 리스트에 추가하는 기능
	public List<BankTransaction> parseLinesFromTSV(List<String> lines) {
		// 전체 입출금 내역 데이터를 가지고 있는 가변 길이 리스트
		// 타입은 단 건 입출금 내역인 BankTransaction을 사용 중
		List<BankTransaction> bankTransactions = new ArrayList<>();
		
		for (String line : lines) {
			BankTransaction bankTransaction = parseFromTSV(line);
			bankTransactions.add(bankTransaction); // 배열의 요소로 추가
		}
		
		return bankTransactions;
	}
}