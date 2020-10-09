package com.cognizant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Package Not Found")
public class PackageNotFoundException extends Exception {
	public PackageNotFoundException(String msg)
	{
		super(msg);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
