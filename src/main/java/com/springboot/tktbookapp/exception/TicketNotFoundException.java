package com.springboot.tktbookapp.exception;

public class TicketNotFoundException extends Exception {

	private static final long serialVersionUID = -9079454849611061074L;

	public TicketNotFoundException() {
		super();
	}

	public TicketNotFoundException(final String message) {
		super(message);
	}

}
