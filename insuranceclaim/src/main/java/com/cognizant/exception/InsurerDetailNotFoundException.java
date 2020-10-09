package com.cognizant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason = "Item with Given Name Not Found")
public class InsurerDetailNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

}
