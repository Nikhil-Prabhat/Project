package com.cognizant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class PackageNotFoundAdvice 
{
	@ResponseBody
	@ExceptionHandler(PackageNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String employeeNotFoundHandler(PackageNotFoundException ex)
	{
		return ex.getMessage();
	}
}
