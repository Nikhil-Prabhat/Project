package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.AuthResponse;
import com.cognizant.model.UserLoginCredential;
import com.cognizant.model.UserToken;
import com.cognizant.repository.UserRepository;
import com.cognizant.service.CustomerDetailsService;
import com.cognizant.service.JwtUtil;



@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private JwtUtil jwtutil;
	@Autowired
	private CustomerDetailsService Custdetailservice;
	@Autowired
	private UserRepository urepo;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody UserLoginCredential userlogincredentials)
	{
		final UserDetails userdetails = Custdetailservice.loadUserByUsername(userlogincredentials.getUid()); 
		return new ResponseEntity<>(new UserToken(userlogincredentials.getUid(),jwtutil.generateToken(userdetails)),HttpStatus.OK);

	}
	
	@RequestMapping(value="/validate",method=RequestMethod.GET)
	public ResponseEntity<?> getValidity(@RequestHeader("Authorization") String token)
	{
		token=token.substring(7);
		AuthResponse res=new AuthResponse();
		if(jwtutil.validateToken(token))
		{
			res.setUid(jwtutil.extractUsername(token));
			res.setValid(true);
			res.setName((urepo.findById(jwtutil.extractUsername(token)).orElse(null).getUname()));
			
		}
		else
			res.setValid(false);
		System.out.println("res:"+res);
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	
}
