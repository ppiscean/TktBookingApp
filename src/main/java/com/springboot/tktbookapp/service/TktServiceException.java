package com.springboot.tktbookapp.service;

public class TktServiceException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9029913700873530388L;
	
	public TktServiceException()
	{
		super();
	}

	public TktServiceException(final String exMessage)
	{
		super(exMessage);
	}

}
