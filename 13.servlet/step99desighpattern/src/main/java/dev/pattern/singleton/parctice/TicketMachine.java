package dev.pattern.singleton.parctice;

import java.util.UUID;

public class TicketMachine {
	private static final int MAX_TICKET_LIMIT = 5;
	private int currentTicketCount = 0;
	private long[] VALID_SERIAL_NUMBERS = new long[5];
	
	private TicketMachine () {}

	private static final TicketMachine machine = new TicketMachine();
	
	public Ticket getTicket() {
		if (MAX_TICKET_LIMIT < currentTicketCount) {
			return new InvalidTicket();
		}
		
		long serialNum = UUID.randomUUID().getMostSignificantBits();
		VALID_SERIAL_NUMBERS[currentTicketCount++] = serialNum;
		return new ValidTicket(serialNum);
	}
	
	public TicketMachine operateTicketMachine() {
		return machine;
	}
	
	public void checkValidTicket(Ticket ticket) {
		
	}
	
	public String toString() {
		
	}
}
