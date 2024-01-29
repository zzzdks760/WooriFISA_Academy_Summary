package dev.spring;

import org.springframework.stereotype.Component;

@Component // 스프링의 컴포넌트 스캔 대상이 되어 컨테이너가 관리하는 Bean으로 등록
public class TapeReader {

	private Tape tape;

	public TapeReader(Tape tape) {
		super();
		this.tape = tape;
		System.out.println("TapeReader 생성자 호출");
	}

	public void test() {

		if (tape.isWorked()) {
			System.out.println(tape.getName() + " 정상 동작합니다");
		} else {
			System.out.println(tape.getName() + " 사기 당했습니다");
		}

	}

	@Override
	public String toString() {
		return "TapeReader 입니다.";
	}

}
