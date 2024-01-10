package dev.syntax.step01basic;

import java.util.Date;
import java.util.logging.Filter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {

	@Override
	public String format(LogRecord record) { // 로거 객체가 로그레코드(로깅 내용 담고 있음) 객체를 전달... 기레서 이걸 받아야제..! @@@@@교안 참고
		return record.getSourceClassName()+"::"
                +record.getSourceMethodName()+"::"
                +new Date(record.getMillis())+"::"
                +record.getMessage()+"\n";
	}

}
