package dev.pattern.singleton.parctice;

public class User {
	private Ticket ticket;

	public void useTicketMachine() {
		TicketMachine machine = TicketMachine.operateTicketMachine();
		ticket = machine.getTicket();
	}
	
	public Ticket getMyTicket() {
		return ticket;
	}
	
	
	public String toString() {
		return "User 인스턴스의 주소값: " + this.toString();
	}
}
