package com.cognizant.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.client.AuthClient;
import com.cognizant.client.AuthResponse;
import com.cognizant.entity.InitiateClaim;
import com.cognizant.entity.InsurerDetail;
import com.cognizant.exception.InsurerNotFoundException;
import com.cognizant.service.InsuranceClaimServiceImpl;


@RestController
@RequestMapping("/insuranceclaim")
public class InsuranceclaimController {
	
	@Autowired
	private InsuranceClaimServiceImpl service;
	
	@Autowired
	private AuthClient authClient;
	
	@GetMapping("/getallinsurerdetail")
	public ResponseEntity<?> getAllInsurer(@RequestHeader(name="Authorization")String token)
	{
		AuthResponse authResponse = authClient.getValidity(token);
		if(authResponse.isValid())
		{
			return new ResponseEntity<>(service.getallInsurerDetail(),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("You are not LoggedIn",HttpStatus.FORBIDDEN);
		}
	}
	
	@GetMapping("/getinsurerbypackagename/{insurerpackageName}")
	public ResponseEntity<?> getInsurerByName(@RequestHeader(name="Authorization")String token,@PathVariable("insurerpackageName")String insurerPackageName)throws InsurerNotFoundException
	{
		AuthResponse authResponse = authClient.getValidity(token);
		if(authResponse.isValid())
		{
			List<InsurerDetail> insurerdetail=service.getInsurerByName(insurerPackageName);
			if(!insurerdetail.isEmpty())
			{
			return new ResponseEntity<>(insurerdetail,HttpStatus.OK);
			}
			else
			{
				throw new InsurerNotFoundException(insurerPackageName+"not found");
			}
			}
		else
		{
			return new ResponseEntity<>("You are not LoggedIn",HttpStatus.FORBIDDEN);
		}
	}
	
	
	
	@PostMapping("/initiateclaim")
	public ResponseEntity<?> balanceamounttobepaid(@RequestHeader(name="Authorization")String token,@RequestBody InitiateClaim initiateclaim)
	{
		AuthResponse authResponse = authClient.getValidity(token);
		if(authResponse.isValid())
		{
			int balanceamounttobepaid = service.balanceamounttobepaid(token,initiateclaim);
			return new ResponseEntity<>(balanceamounttobepaid,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("You are not LoggedIn",HttpStatus.FORBIDDEN);
		}
		
	}

}
