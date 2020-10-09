package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.client.AuthClient;
import com.cognizant.client.AuthResponse;
import com.cognizant.entity.IPTreatmentPackages;
import com.cognizant.entity.SpecialistDetails;
import com.cognizant.exception.PackageNotFoundException;
import com.cognizant.service.IPTreatmentService;

@RestController
@RequestMapping("/ipofferings")
public class IPTreatmentOfferingsController 
{
	@Autowired
	private IPTreatmentService ipTreatmentService;
	
	@Autowired
	private AuthClient authClient;
	
	@GetMapping("/iptreatmentpackages")
	public ResponseEntity<?> getAllPackages(@RequestHeader(name="Authorization")String token) {
		
		AuthResponse authResponse=authClient.verifyToken(token);
		if(authResponse.isValid())
		{
			List<IPTreatmentPackages> allPackages = ipTreatmentService.getAllPackages();
			return new ResponseEntity<>(allPackages, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("You are not LoggedIn",HttpStatus.FORBIDDEN);
		}
		
	}

	@GetMapping("/iptreatmentpackageByName/{packageName}")
	public ResponseEntity<?> getPackageByName(@RequestHeader(name="Authorization")String token,@PathVariable("packageName")String packageName) throws PackageNotFoundException {
		AuthResponse authResponse=authClient.verifyToken(token);
		if(authResponse.isValid())
		{
			List<IPTreatmentPackages> packageByName = ipTreatmentService.getPackageByName(packageName);
			if (!packageByName.isEmpty()) {
				return new ResponseEntity<>(packageByName, HttpStatus.OK);
			} else {
				throw new PackageNotFoundException(packageName+" Not Found");
			}
		}
		else
		{
			return new ResponseEntity<>("You are not LoggedIn",HttpStatus.FORBIDDEN);
		}
	}

	@GetMapping("/specialists")
	public ResponseEntity<?> getAllSpecialists(@RequestHeader(name="Authorization")String token) {
		
		AuthResponse authResponse=authClient.verifyToken(token);
		if(authResponse.isValid())
		{
			List<SpecialistDetails> allSpecialists = ipTreatmentService.getAllSpecialists();
			return new ResponseEntity<>(allSpecialists, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("You are not LoggedIn",HttpStatus.FORBIDDEN);
		}
	}
}
