package com.piyush.crm.entity;

public class CustomError {
	
	int code;
	String message;
	Long timeStamp;
	/**
	 * @param code
	 * @param message
	 * @param timeStamp
	 */
	public CustomError(int code, String message, Long timeStamp) {
		super();
		this.code = code;
		this.message = message;
		this.timeStamp = timeStamp;
	}
	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the timeStamp
	 */
	public Long getTimeStamp() {
		return timeStamp;
	}
	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	

}
