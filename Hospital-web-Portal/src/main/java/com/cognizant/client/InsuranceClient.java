package com.cognizant.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.model.InitiateClaim;
import com.cognizant.model.InsurerDetail;





@FeignClient(url = "http://localhost:8083/insuranceclaim", name = "insurance")
public interface InsuranceClient {
	
	@GetMapping("/getallinsurerdetail")
	public List<InsurerDetail> getAllInsurer(@RequestHeader(name="Authorization")String token);
	
	@PostMapping("/initiateclaim")
	public int balanceamounttobepaid(@RequestHeader(name="Authorization")String token,@RequestBody InitiateClaim initiateclaim);

}
