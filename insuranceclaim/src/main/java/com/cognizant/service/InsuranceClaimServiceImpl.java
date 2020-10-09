package com.cognizant.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.client.IPTreatmentServiceClient;
import com.cognizant.entity.InitiateClaim;
import com.cognizant.entity.InsurerDetail;
import com.cognizant.model.InsuranceInfo;
import com.cognizant.repository.InitiateClaimRepository;
import com.cognizant.repository.InsurerDetailRepository;


@Service
public class InsuranceClaimServiceImpl implements InsuranceClaimService 
{
	@Autowired
	private InitiateClaimRepository initiateClaimRepository;
	
	@Autowired
	private InsurerDetailRepository insurerDetailRepository;
	
	@Autowired
	private IPTreatmentServiceClient ipclient;
	


	@Override
	public List<InsurerDetail> getallInsurerDetail() {
		return insurerDetailRepository.findAll();
	}

	@Override
	public List<InsurerDetail> getInsurerByName(String insurerpackageName) {
		return insurerDetailRepository.findByName(insurerpackageName);
	}

	@Override
	public int balanceamounttobepaid(String token,InitiateClaim initiateclaim) {
		
		InsuranceInfo insurance = ipclient.getInsurance(token, initiateclaim.getPatientname(), initiateclaim.getAilment(),
				initiateclaim.getTreatmentPackageName());
		
		initiateClaimRepository.save(initiateclaim);
		
		InsurerDetail findInsurer = insurerDetailRepository.findInsurer(initiateclaim.getInsurerName());
		
		return insurance.getCost()-findInsurer.getInsuranceAmountLimit();
		
	}
}
	
	
	
	
	