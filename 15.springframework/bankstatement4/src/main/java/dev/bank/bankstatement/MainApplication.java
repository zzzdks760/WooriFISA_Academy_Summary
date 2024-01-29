package dev.bank.bankstatement;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.bank.bankstatement.data.BankStatementParser;
import dev.bank.bankstatement.data.BankStatementTSVParser;

public class MainApplication {

	public static void main(String[] args) throws IOException {
		final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
		
//		final BankStatementFactory factory = new BankStatementFactory();
		
//		final BankStatementParser bankStatementParser =  factory.createCSVParser(); // or new BankStatementTSVParser();

//		spring 적용
		final ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfigWithComponentScan.class);
//		컨테이너 생성
		final BankStatementParser bankStatementParser = context.getBean(BankStatementParser.class);
//		의존성(Bean)꺼냄
		bankStatementAnalyzer.analyze("bank-data-simple.txt", bankStatementParser);
		
	}
	
}