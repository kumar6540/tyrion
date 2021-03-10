package com.rest.RestApiServices.entity;

import org.springframework.stereotype.Component;

@Component
public class EmployeeError {
	

	private int status;
	private String message;
	private long timeStamp;
	


	public EmployeeError() {
	}
	
	
	
	public int getStatus() {
		return status;
	}




	public void setStatus(int status) {
		this.status = status;
	}




	public String getMessage() {
		return message;
	}




	public void setMessage(String message) {
		this.message = message;
	}



	public long getTimeStamp() {
		return timeStamp;
	}



	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}





}
