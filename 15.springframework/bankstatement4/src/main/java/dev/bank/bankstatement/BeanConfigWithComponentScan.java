package dev.bank.bankstatement;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// xml파일을 대체할 bean 정보 구성용 java 파일(클래스)
// -> Bean 설정 파일의 포멧(확장자)만 바뀌었음
@ComponentScan(basePackages = "dev.bank.bankstatement")
@Configuration
public class BeanConfigWithComponentScan {
	
}
