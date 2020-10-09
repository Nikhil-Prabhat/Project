package com.cognizant.service;

import java.util.List;

import com.cognizant.entity.InitiateClaim;
import com.cognizant.entity.InsurerDetail;

public interface InsuranceClaimService
{
	public List<InsurerDetail> getallInsurerDetail();
	public List<InsurerDetail> getInsurerByName(String insurerPackageName);
	public int balanceamounttobepaid( String token,InitiateClaim initiateclaim);

}
