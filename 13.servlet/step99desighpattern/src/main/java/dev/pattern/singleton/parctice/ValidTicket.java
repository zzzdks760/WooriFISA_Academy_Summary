package dev.pattern.singleton.parctice;

public class ValidTicket extends Ticket{

	public ValidTicket(long serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Override
	public long getTicketNum() {
		return serialNumber;
	}

	@Override
	public boolean isValid() {
		return true;
	}
}
