package dev.pattern.singleton.parctice;

public class Main {

	public static void main(String[] args) {
        TicketMachine ticketMachine = TicketMachine.operateTicketMachine();

        User user1 = new User();
        User user2 = new User();

        user1.useTicketMachine();
        user2.useTicketMachine();

        Ticket ticket1 = user1.getMyTicket();
        Ticket ticket2 = user2.getMyTicket();

        ticketMachine.checkValidTicket(ticket1);
        ticketMachine.checkValidTicket(ticket2);

        user1.useTicketMachine();
        user2.useTicketMachine();

        Ticket invalidTicket1 = user1.getMyTicket();
        Ticket invalidTicket2 = user2.getMyTicket();

        ticketMachine.checkValidTicket(invalidTicket1);
        ticketMachine.checkValidTicket(invalidTicket2);

	}

	
}
