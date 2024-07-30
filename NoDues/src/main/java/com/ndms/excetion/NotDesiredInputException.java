package com.ndms.excetion;

public class NotDesiredInputException extends RuntimeException {

	private String mesage;
	
	public NotDesiredInputException() {
		// TODO Auto-generated constructor stub
	}

	public NotDesiredInputException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NotDesiredInputException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NotDesiredInputException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NotDesiredInputException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
