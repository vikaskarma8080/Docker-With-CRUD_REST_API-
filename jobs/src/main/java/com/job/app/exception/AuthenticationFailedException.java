package com.job.app.exception;

public class AuthenticationFailedException extends RuntimeException{

	public AuthenticationFailedException() {
		super("Authentication Failed");
	}
	public AuthenticationFailedException(String msg) {
		super(msg);
	}
}
