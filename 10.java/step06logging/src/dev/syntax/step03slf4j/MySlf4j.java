package dev.syntax.step03slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySlf4j {
	private static final Logger logger = LoggerFactory.getLogger(MySlf4j.class);
	public static void main(String[] args) {
		logger.info("INFO");
		logger.error("ERROR");
	}

}
