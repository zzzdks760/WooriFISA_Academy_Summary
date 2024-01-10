package dev.syntax.step01basic;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {

	@Override
	public String format(LogRecord record) {
		return "loggerName: " + record.getLoggerName() + " message: " + record.getMessage() + "\n";
	}

}
