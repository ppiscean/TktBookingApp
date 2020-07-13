package com.springboot.tktbookapp.exception;

public class RequiredFiledsException extends Exception {

	private static final long serialVersionUID = -9079454849611061074L;

	public RequiredFiledsException() {
		super();
	}

	public RequiredFiledsException(final String message) {
		super(message);
	}

}
