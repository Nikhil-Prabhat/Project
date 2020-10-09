package com.cognizant.service;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.entity.InsurerDetail;
import com.cognizant.service.InsuranceClaimService;
import com.cognizant.service.InsuranceClaimServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InsuranceClaimServiceImplTest {

	@Autowired
	private InsuranceClaimService  insurerclaimservice;
	
	@Test
	public void testGetAllInsurerDetail()
	{
		List<InsurerDetail> insurer = insurerclaimservice.getallInsurerDetail();
		assertEquals(insurer.get(0).getInsurerId(), new Integer(1));
	}
	
	@Test
	public void testgetInsurerByName()
	{
		InsurerDetail detail = new InsurerDetail(12,"ABC","Package 123",3500, 4); 
		List<InsurerDetail> insurerDetail = insurerclaimservice.getInsurerByName
				(detail.getInsurerPackageName());
		assertEquals(insurerDetail.get(0).getInsurerPackageName(),"Package 123");
	}
	
	
	

}

