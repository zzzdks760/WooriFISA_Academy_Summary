package dev.pattern.singleton.parctice;

import java.util.UUID;

public class TicketMachine {
	private static final int MAX_TICKET_LIMIT = 3;
	private int currentTicketCount = 0;
	private long[] VALID_SERIAL_NUMBERS = new long[5];
	
	private TicketMachine () {}

	private static final TicketMachine machine = new TicketMachine();
	
	public Ticket getTicket() {
		if (MAX_TICKET_LIMIT <= currentTicketCount) {
			System.out.println("Invalid 생성");
			return new InvalidTicket();
		}
		
		long serialNum = UUID.randomUUID().getMostSignificantBits();
		VALID_SERIAL_NUMBERS[currentTicketCount++] = serialNum;
		System.out.println(currentTicketCount);
		return new ValidTicket(serialNum);
	}
	
	public static TicketMachine operateTicketMachine() {
		return machine;
	}
	
	public void checkValidTicket(Ticket ticket) {
        if (ticket.isValid()) {
            System.out.println("티켓이 유효합니다. 티켓 번호: " + ticket.getTicketNum());
        } else {
            System.out.println("티켓이 유효하지 않습니다.");
        }
    }
	
	public String toString() {
		return "티켓 발행기의 고유번호: " + machine.hashCode();
	}
}
