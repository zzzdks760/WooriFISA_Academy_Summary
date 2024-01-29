package dev.spring.step03constructor;

import org.springframework.beans.factory.annotation.Autowired;

public class TapeReader {

	private Tape tape;

	@Autowired
	public TapeReader(Tape tape) {
		System.out.println("constructor called" + tape);
		this.tape = tape;
	}

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

	
}
