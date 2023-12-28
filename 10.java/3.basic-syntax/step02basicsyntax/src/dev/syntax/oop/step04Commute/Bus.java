package dev.syntax.oop.step04Commute;

public class Bus {
	private String number;
	private Transport transport;
	
	public void boardBus(Student student) {
		transport.board(student, 2000);
		transport.transportInfo("버스: ", number);
	}
	
	public Bus(String number, Transport transport) {
		this.number = number;
		this.transport = transport;
	}
}
