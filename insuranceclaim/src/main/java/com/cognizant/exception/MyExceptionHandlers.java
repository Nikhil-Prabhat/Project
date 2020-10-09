package com.cognizant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandlers {
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> myMessage(UserNotFoundException c)
	{
		return new ResponseEntity<>(c.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

}


