package com.user.registration.exception;

public class UserRegistrationException extends RuntimeException {

	private String fieldName;
	private String fieldValue;
	private String description;

	public UserRegistrationException(String fieldName, String fieldValue, String description) {
		super(String.format("Error with field: %s, value: %s, description: %s", fieldName, fieldValue, description));
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
		this.description = description;
	}

	public String getFieldName() {
		return fieldName;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public String getDescription() {
		return description;
	}

}
