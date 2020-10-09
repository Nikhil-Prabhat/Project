package com.cognizant.client;

import java.util.Date;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.exception.PackageNotFoundException;
import com.cognizant.model.InsuranceInfo;
import com.cognizant.model.PatientDetail;
import com.cognizant.model.TreatmentPlan;

@FeignClient(url = "http://localhost:8081/treatment", name = "IP-Treatment-Offerings-Service")
public interface TreatmentClient {
	@GetMapping("/formulateTreatmentTimetable")
	public TreatmentPlan formulateTreatmentTimetable(@RequestHeader(name = "Authorization") String token,
			@RequestParam("name") String name, @RequestParam("age") int age, @RequestParam("ailment") String ailment,
			@RequestParam("treatmentPackageName") String treatmentPackageName,
			@RequestParam("treatmentCommencementDate") String treatmentCommencementDate) throws PackageNotFoundException;

	@GetMapping("/getallpatients")
	public List<PatientDetail> getAllPatients(@RequestHeader(name = "Authorization") String token);

	@GetMapping("/insurance")
	public InsuranceInfo getInsurance(@RequestHeader(name = "Authorization") String token,
			@RequestParam("name") String name, @RequestParam("ailment") String ailment,
			@RequestParam("treatmentPackageName")  String treatmentPackageName);

}
