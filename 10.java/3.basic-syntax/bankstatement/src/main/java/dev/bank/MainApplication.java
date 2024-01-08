package dev.bank;

public class MainApplication {

	public static void main(String[] args) {
		
		// 입출금 분석기 생성
		BankStatementAnalyzer analyzer = new BankStatementAnalyzer();
		
		// 조건에 따라 parser 구현체 분기
		analyzer.analyze(args[0]);
//		analyzer.analyze("bank-data.csv");
		
	}

}
