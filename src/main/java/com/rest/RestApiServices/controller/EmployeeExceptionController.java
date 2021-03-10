package com.rest.RestApiServices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rest.RestApiServices.entity.EmployeeError;


@ControllerAdvice
public class EmployeeExceptionController {

	@Autowired
	private EmployeeError error;
	
	public EmployeeExceptionController() {
		// TODO Auto-generated constructor stub
	}
	
	@ExceptionHandler
	public ResponseEntity<EmployeeError> HandleException(com.rest.RestApiServices.exception.EmployeeCustomException exe){
		
		error.setTimeStamp(System.currentTimeMillis());
		error.setMessage(exe.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<EmployeeError>(error,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<EmployeeError> HandleException(Exception exe){
		
		error.setTimeStamp(System.currentTimeMillis());
		error.setMessage(exe.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		
		return new ResponseEntity<EmployeeError>(error,HttpStatus.BAD_REQUEST);
	}
	
	
	
}
