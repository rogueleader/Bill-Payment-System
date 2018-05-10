package com.bps.exceptions;

public class ApplicationException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;

	
	public ApplicationException() {
		super();
	}

	public ApplicationException(final String  errCode) {
		this.errorCode = errCode;
	}
	
	public ApplicationException(final String errCode,final  Throwable cause) {
		super(errCode, cause);
	}
	
	public ApplicationException(final  Throwable cause) {
		super(cause);
	}
	
	public String getErrorCode() {
		return errorCode;
	}

}
