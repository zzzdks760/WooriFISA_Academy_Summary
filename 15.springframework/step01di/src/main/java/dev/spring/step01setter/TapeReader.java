package dev.spring.step01setter;

import org.springframework.context.annotation.Bean;

public class TapeReader {

	private Tape tape;

	public void test() {

		if (tape.isWorked()) {
			System.out.println(tape.getName() + " 정상 동작합니다");
		} else {
			System.out.println(tape.getName() + " 사기 당했습니다");
		}

	}

	public void setTape(Tape tape) {
		System.out.println("setTape(Tape tape) called");
		this.tape = tape;
	}

	@Override
	public String toString() {
		return "TapeReader 입니다.";
	}

	public TapeReader(Tape tape) {
		this.tape = tape;
	}
	
}
