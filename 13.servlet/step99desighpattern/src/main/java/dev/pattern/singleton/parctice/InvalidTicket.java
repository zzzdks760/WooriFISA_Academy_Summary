package dev.pattern.singleton.parctice;

public class InvalidTicket extends Ticket{

	
	
	public InvalidTicket() {
		this.serialNumber = 0;
	}

	@Override
	public long getTicketNum() {
		return serialNumber;
	}

}
