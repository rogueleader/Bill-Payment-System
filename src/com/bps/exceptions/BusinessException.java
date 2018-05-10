package com.bps.exceptions;

import java.util.List;

public class BusinessException extends Exception{
	
	
	private static final long serialVersionUID = 1L;
	
	public BusinessException() {
		// TODO Auto-generated constructor stub
		}
	
	public BusinessException(String message){
		super(message);// Calling to the super class constructor
	}

	public BusinessException(final String message,
			final Throwable exception) {
		super(message, exception);// Calling to the super class constructor

	}
	public BusinessException(final Throwable exception) {
		super(exception);// Calling to the super class constructor
	}
	private List<String> errorList;

	public List<String> getErrorList() {
	return errorList;
	}

	public void setErrorList(List<String> errorList) {
	this.errorList = errorList;
	}

}
