package dev.pattern.singleton.parctice;

public class User {
	Ticket ticket;
	
	public User(Ticket ticket) {
		this.ticket = ticket;
	}

	public void useTicketMachine() {
		TicketMachine machine = TicketMachine.getTicket();
	}
	
	Ticket getMyTicket() {
		
	}
	
	String toString() {
		
	}
}
