package com.example.exercise.exception;

public class ProductNotFoundException extends RuntimeException {
	private final String errorCode;

	public ProductNotFoundException(String message, String errorCode) {
		super(message); this.errorCode = errorCode;
	}
	public String getErrorCode() {
		return errorCode;
	}
}