package com.hosny.employeemanager.exception;

public class UserNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7701364410109316981L;

	public UserNotFoundException(String message) {
		super(message);
	}
}
