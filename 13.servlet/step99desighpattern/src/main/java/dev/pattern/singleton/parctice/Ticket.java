package dev.pattern.singleton.parctice;

public abstract class Ticket {
	
	long serialNumber;
	
	public abstract long getTicketNum();
	
	public abstract boolean isValid();
}
