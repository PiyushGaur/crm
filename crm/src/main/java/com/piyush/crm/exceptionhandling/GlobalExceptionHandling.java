package com.piyush.crm.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.piyush.crm.entity.CustomError;

@ControllerAdvice
public class GlobalExceptionHandling {
	
	@ExceptionHandler
	public ResponseEntity<CustomError> handleExceptionGeneric(Exception exc){
		//System.out.println("dmbn");
		CustomError ce = new CustomError(HttpStatus.BAD_REQUEST.value(),exc.getMessage(),System.currentTimeMillis());
		return new ResponseEntity<>(ce,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<CustomError> handleExceptionGeneric(EntityNotFoundException exc){
		//System.out.println("dmbn");
		CustomError ce = new CustomError(HttpStatus.BAD_REQUEST.value(),exc.getMessage(),System.currentTimeMillis());
		return new ResponseEntity<>(ce,HttpStatus.NOT_FOUND);
	}
}
