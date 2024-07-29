package com.job.app.exception;


public class UserAlreadyPresentException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UserAlreadyPresentException() {
		super("User Already Present ");
	}
	public UserAlreadyPresentException(String msg) {
		super(msg);
	}
}
