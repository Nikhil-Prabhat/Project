package com.cognizant.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.client.AuthClient;
import com.cognizant.client.AuthResponse;
import com.cognizant.controller.InsuranceclaimController;
import com.cognizant.entity.InitiateClaim;
import com.cognizant.entity.InsurerDetail;
import com.cognizant.exception.InsurerNotFoundException;
import com.cognizant.repository.InitiateClaimRepository;
import com.cognizant.repository.InsurerDetailRepository;
import com.cognizant.service.InsuranceClaimServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InsurerClaimControllerTest {
	@Mock
	private InsuranceClaimServiceImpl insurerclaimserviceimpl;
	
	@InjectMocks
	private InsuranceclaimController insurerclaimController;
	
	@Mock
	private AuthClient tokenproxy;
	
	@Mock
	private InsurerDetailRepository insurerdetailRepo;
	
	@Mock
	private InitiateClaimRepository initiateclaimRepo;
	
	@Mock
	private InitiateClaim initiateclaim;
	
	@Mock
	private InsurerDetail insurerdetail;
	
	@Before
	public void setup()
	{
		initiateclaim.setId(10);
		initiateclaim.setPatientname("ABC");
		initiateclaim.setAilment("xyz");
		initiateclaim.setTreatmentPackageName("Package 5");
		initiateclaim.setInsurerName("Avik");
		
		insurerdetail.setInsurerId(123);
		insurerdetail.setInsurerName("Avik");
		insurerdetail.setInsurerPackageName("Package 10");
		insurerdetail.setInsuranceAmountLimit(2000);
		insurerdetail.setDisbursementDuration(8);
	}
	
	@Test
	public void testGetAllInsurerPass()
	{
		Mockito.when(tokenproxy.getValidity("token")).thenReturn(new AuthResponse("admin","admin",true));
		ResponseEntity<?> getAllPackages=insurerclaimController.getAllInsurer("token");
		assertNotNull(getAllPackages);
	}
	
	@Test
	public void  testGetAllInsurerFail()
	{
		Mockito.when(tokenproxy.getValidity("token")).thenReturn(new AuthResponse("admin","admin",false));
		ResponseEntity<?> getAllPackages=insurerclaimController.getAllInsurer("token");
		assertEquals(403,getAllPackages.getStatusCodeValue());
	}
	@Test
	public void	testGetInsurerByNameFound() throws InsurerNotFoundException 
	{
		Mockito.when(tokenproxy.getValidity("token")).thenReturn(new AuthResponse("admin","admin",true));
		List<InsurerDetail> list = new ArrayList<InsurerDetail>();
		list.add(insurerdetail);
		Mockito.when(insurerclaimserviceimpl.getInsurerByName("Avik")).thenReturn(list);
		ResponseEntity<?> packages = insurerclaimController.getInsurerByName("token","Avik");
		assertEquals(200, packages.getStatusCodeValue());
		assertNotNull(packages);
	}
	@Test(expected = InsurerNotFoundException.class)
	public void	testGetInsurerByNameNotFound()throws InsurerNotFoundException 
	{
		Mockito.when(tokenproxy.getValidity("token")).thenReturn(new AuthResponse("admin","admin",true));
		List<InsurerDetail> list = new ArrayList<InsurerDetail>();
		Mockito.when(insurerclaimserviceimpl.getInsurerByName("AABB")).thenReturn(list);
		ResponseEntity<?> packages = insurerclaimController.getInsurerByName("token","AABB");
		assertEquals(404, packages.getStatusCodeValue());
		assertNotNull(packages);
	}
	@Test
	public void testGetInsurerByNameFail() throws InsurerNotFoundException
	{
		Mockito.when(tokenproxy.getValidity("token")).thenReturn(new AuthResponse("admin","admin",false));
		ResponseEntity<?> packages = insurerclaimController.getInsurerByName("token","abcd");
		assertEquals(403, packages.getStatusCodeValue());
	}
	
	
}
