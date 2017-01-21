package com.bt.rest.crud.provider;

public class InvalidCustomerException extends Exception {

	public InvalidCustomerException() {
		super();
		
	}

	public InvalidCustomerException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public InvalidCustomerException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public InvalidCustomerException(String message) {
		super(message);
		
	}

	public InvalidCustomerException(Throwable cause) {
		super(cause);
		
	}

}
