package dev.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// xml파일을 대체할 bean 정보 구성용 java 파일(클래스)
// -> Bean 설정 파일의 포멧(확장자)만 바뀌었음
@Configuration
public class BeanConfig {
	
	@Bean
	public TapeReader tapeReader(Tape tape) {
		return new TapeReader(tape);
	}
	
	@Bean
	public Tape bean() {
		return new Tape("아일랜드", true);
	}
}
