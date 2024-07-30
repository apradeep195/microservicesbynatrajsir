package com.ndms.excetion;

public class AnonymousUserException extends RuntimeException {
	
	private String mesage;
	
	public AnonymousUserException() {
		// TODO Auto-generated constructor stub
	}

	public AnonymousUserException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public AnonymousUserException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AnonymousUserException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AnonymousUserException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
