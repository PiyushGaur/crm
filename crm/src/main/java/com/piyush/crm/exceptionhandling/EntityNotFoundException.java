package com.piyush.crm.exceptionhandling;

public class EntityNotFoundException extends RuntimeException {
	
	String errorMessage;

	/**
	 * @param errorMessage
	 */
	public EntityNotFoundException(String errorMessage) {
		super(errorMessage);
		//this.errorMessage = errorMessage;
	}
	

}
