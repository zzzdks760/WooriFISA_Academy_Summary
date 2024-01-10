package dev.syntax.step01basic;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Step05UsingFilter {
	
	// 로깅을 수행할 Logger 객체 생성
	private static final Logger logger = 
			Logger.getLogger(Step05UsingFilter.class.getName());

	public static void main(String[] args) {
		// 기본 로그의 출력 레벨은 INFO(기본 설정값이 INFO)
		
		logger.log(Level.INFO, "INFO 레벨 출력용 테스트 메시지");
		logger.log(Level.WARNING, "WARNING 레벨 출력용 테스트 메시지");
		logger.log(Level.FINEST, "FINEST 레벨 출력용 테스트 메시지");
		
		// 로그 기록을 파일 형태로 남길 수 있도록 하려면?
		try {
			final String fileName = "myfile.log";
			Handler fileHandler = new FileHandler(fileName);
			
			Formatter logFormatter = new CustomFormatter();
			fileHandler.setFormatter(logFormatter);
						
			logger.addHandler(fileHandler);
			
		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.log(Level.INFO, "INFO 레벨 출력용 테스트 메시지");
		logger.log(Level.WARNING, "WARNING 레벨 출력용 테스트 메시지");
		logger.log(Level.FINEST, "FINEST 레벨 출력용 테스트 메시지");
		
	}

}
