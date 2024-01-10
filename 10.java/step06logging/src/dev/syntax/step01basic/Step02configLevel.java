package dev.syntax.step01basic;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Step02configLevel {

	// 로깅을 수행할 Logger 객체 생성
	private static final Logger logger = Logger.getLogger(Step02configLevel.class.getName());
	
	public static void main(String[] args) {
		/**
		 * 로깅 레벨 변경
		 */
		logger.getGlobal().setLevel(Level.WARNING);
		logger.setLevel(Level.FINEST);
		
		logger.log(Level.SEVERE, "SEVERE 레벨 출력 메시지");
		logger.log(Level.WARNING, "WARNING 레벨 출력 메시지");
		logger.log(Level.INFO, "INFO 레벨 출력 메시지");
		logger.log(Level.CONFIG, "CONFIG 레벨 출력 메시지");
		logger.log(Level.FINE, "FINE 레벨 출력 메시지");
		logger.log(Level.FINER, "FINER 레벨 출력 메시지");
		logger.log(Level.FINEST, "FINEST 레벨 출력 메시지");
	}

}
