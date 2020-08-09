package com.naren.request;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SmsRequest {
	
	@NotBlank
	private final String phoneNumber;
	
	@NotBlank
	private final String message;

	public SmsRequest(@JsonProperty("phoneNumber") String phoneNumber, 
					  @JsonProperty("message") String message) {
		super();
		this.phoneNumber = phoneNumber;
		this.message = message;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "SmsRequest [phoneNumber=" + phoneNumber + ", message=" + message + "]";
	}
	
	
	
	
	

}
