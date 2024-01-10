package dev.syntax.step02exlib;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Mylog4j {
	
	private static final Logger logger = LogManager.getLogger(Mylog4j.class);

	public static void main(String[] args) {
		
//		System.out.println(logger);
		
		logger.error("Error 메시지");
		logger.info("INFO 메시지");
		
	}

}