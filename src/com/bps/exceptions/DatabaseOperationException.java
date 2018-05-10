package com.bps.exceptions;

public class DatabaseOperationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DatabaseOperationException(final String errCode, Throwable cause) {
		super(errCode, cause);
	}

	public DatabaseOperationException(final String errCode) {
		super(errCode);
	}

	public DatabaseOperationException(Throwable throwable) {
		super(throwable);
	}

}
