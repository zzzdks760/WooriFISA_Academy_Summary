package dev.syntax.oop.step04Commute;

public class Subway {
	private String number;
	private Transport transport;
	
	public void boardSubway(Student student) {
		transport.board(student, 1400);
		transport.transportInfo("지하철: ", number);
	}
	
	public Subway(String number, Transport transport) {
		this.number = number;
		this.transport = transport;
	}
}
