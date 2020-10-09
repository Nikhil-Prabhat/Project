package com.cognizant.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.model.InsuranceInfo;

@FeignClient(url="http://localhost:8081/treatment",name = "IP-Treatment-Service")
public interface IPTreatmentServiceClient 
{
	@GetMapping("/insurance")
    public InsuranceInfo getInsurance(@RequestHeader(name="Authorization")String token,
    		@RequestParam("name") String name, @RequestParam("ailment")String ailment,
            @RequestParam("treatmentPackageName") String treatmentPackageName);
}

