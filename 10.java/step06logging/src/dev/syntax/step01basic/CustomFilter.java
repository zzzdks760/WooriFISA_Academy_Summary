package dev.syntax.step01basic;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class CustomFilter implements Filter{

	@Override
	public boolean isLoggable(LogRecord record) {
		if (record.getLevel().intValue() < 900) {
			return true;
		}
		return false;
	}

}
