package com.cognizant.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.model.AuthResponse;
import com.cognizant.model.UserLoginCredential;
import com.cognizant.model.UserToken;

@FeignClient(url = "http://localhost:8090/auth", name = "authapp")
public interface AuthClient {
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public UserToken login(@RequestBody UserLoginCredential userlogincredentials);

	
	@RequestMapping(path = "/validate", method = RequestMethod.GET)
	public AuthResponse verifyToken(@RequestHeader(name = "Authorization", required = true) String token);

}
