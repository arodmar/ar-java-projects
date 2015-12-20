package com.ardevcenter.lnb.rest;

public class GenericResponseMessage<T> {
	
	private boolean success;
	private String[] warnings;
	private T messageBody;
	private String[] errors;
	
	public GenericResponseMessage(boolean success,  T messageBody) {
		this.success = success;		
		this.messageBody = messageBody;		
	}

	public GenericResponseMessage(boolean success, String[] warnings, T messageBody, String[] errors) {

		this.success = success;
		this.warnings = warnings;
		this.messageBody = messageBody;
		this.errors = errors;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String[] getWarnings() {
		return warnings;
	}
	public void setWarnings(String[] warnings) {
		this.warnings = warnings;
	}
	public T getMessageBody() {
		return messageBody;
	}
	public void setMessageBody(T messageBody) {
		this.messageBody = messageBody;
	}
	public String[] getErrors() {
		return errors;
	}
	public void setErrors(String[] errors) {
		this.errors = errors;
	}

	

}
