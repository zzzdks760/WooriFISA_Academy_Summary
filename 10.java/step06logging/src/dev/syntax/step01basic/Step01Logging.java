package dev.syntax.step01basic;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Step01Logging {

	// 로깅을 수행할 Logger 객체 생성
	private static final Logger logger = Logger.getLogger(Step01Logging.class.getName());
	
	public static void main(String[] args) {
		logger.log(Level.INFO, "INFO 레벨 출력 메시지");
		logger.log(Level.WARNING, "WARNING 레벨 출력 메시지");
		logger.log(Level.FINEST, "FINEST 레벨 출력 메시지");
		
		// 기본 로그의 출력 레벨은 INFO
		logger.info("INFO 레벨 출력용 메시지");
	}

}
