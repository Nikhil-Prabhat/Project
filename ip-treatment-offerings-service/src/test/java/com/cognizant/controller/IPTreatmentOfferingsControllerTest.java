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
import com.cognizant.entity.IPTreatmentPackages;
import com.cognizant.entity.PackageDetails;
import com.cognizant.entity.SpecialistDetails;
import com.cognizant.exception.PackageNotFoundException;
import com.cognizant.repository.IPTreatmentRepository;
import com.cognizant.repository.SpecialistRepository;
import com.cognizant.service.IPTreatmentServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IPTreatmentOfferingsControllerTest 
{
	@Mock
	private IPTreatmentServiceImpl ipTreatmentServiceImpl;
	
	@InjectMocks
	private IPTreatmentOfferingsController ipTreatmentOfferingsController;
	
	@Mock
	private AuthClient authClient;
	
	@Mock
	private IPTreatmentRepository ipTreatmentRepository;
	
	@Mock
	private SpecialistRepository specialistRepository;
	
	@Mock
	private IPTreatmentPackages ipTreatmentPackages;
	
	@Mock
	private PackageDetails packageDetails;
	
	@Mock
	private SpecialistDetails specialistDetails;
	
	AuthResponse authResponse;
	
	@Before
	public void setup()
	{
		ipTreatmentPackages.setAilmentId(12);
		ipTreatmentPackages.setAilmentCategory("ABC");
		packageDetails.setTreatmentPackageName("ABCD");
		packageDetails.setTestDetails("XYZ");
		packageDetails.setCost(3000);
		packageDetails.setTreatmentDuration(4);
		ipTreatmentPackages.setPackageDetails(packageDetails);
		specialistDetails.setSpecialistId(15);
		specialistDetails.setName("XYZ");
		specialistDetails.setAreaOfExpertise("PQRS");
		specialistDetails.setExperienceInYears(5);
		specialistDetails.setContactNumber(new Long(1234567890));
	}
	
	@Test
	public void testGetAllPackagesPass()
	{
		Mockito.when(authClient.verifyToken("token")).thenReturn(new AuthResponse("admin", "admin", true));
		ResponseEntity<?> getAllPackages=ipTreatmentOfferingsController.getAllPackages("token");
		assertNotNull(getAllPackages);
	}
	
	@Test
	public void testGetAllPackagesFail()
	{
		Mockito.when(authClient.verifyToken("token")).thenReturn(new AuthResponse("admin", "admin", false));
		ResponseEntity<?> getAllPackages=ipTreatmentOfferingsController.getAllPackages("token");
		assertEquals(403, getAllPackages.getStatusCodeValue());
	}
	
	@Test
	public void testGetPackageByNameFound() throws PackageNotFoundException
	{
		Mockito.when(authClient.verifyToken("token")).thenReturn(new AuthResponse("admin", "admin", true));
		List<IPTreatmentPackages> list=new ArrayList<IPTreatmentPackages>();
		list.add(ipTreatmentPackages);
		Mockito.when(ipTreatmentServiceImpl.getPackageByName("ABCD")).thenReturn(list);
		ResponseEntity<?> packages=ipTreatmentOfferingsController.getPackageByName("token", "ABCD");
		assertEquals(200, packages.getStatusCodeValue());
		assertNotNull(packages);
	}
	
	@Test(expected = PackageNotFoundException.class)
	public void testGetPackageByNameNotFound() throws PackageNotFoundException 
	{
		Mockito.when(authClient.verifyToken("token")).thenReturn(new AuthResponse("admin", "admin", true));
		List<IPTreatmentPackages> list=new ArrayList<IPTreatmentPackages>();
		Mockito.when(ipTreatmentServiceImpl.getPackageByName("QWER")).thenReturn(list);
		ResponseEntity<?> packages=ipTreatmentOfferingsController.getPackageByName("token", "QWER");
		assertEquals(404, packages.getStatusCodeValue());
		assertNotNull(packages);
	}
	
	@Test
	public void testGetPackageByNameFail() throws PackageNotFoundException
	{
		Mockito.when(authClient.verifyToken("token")).thenReturn(new AuthResponse("admin", "admin", false));
		ResponseEntity<?> packages=ipTreatmentOfferingsController.getPackageByName("token", "ABCD");
		assertEquals(403, packages.getStatusCodeValue());
	}
	
	@Test
	public void testGetAllSpecialistsPass()
	{
		Mockito.when(authClient.verifyToken("token")).thenReturn(new AuthResponse("admin", "admin", true));
		ResponseEntity<?> getAllSpecialists=ipTreatmentOfferingsController.getAllSpecialists("token");
		assertNotNull(getAllSpecialists);
	}
	
	@Test
	public void testGetAllSpecialistsFail()
	{
		Mockito.when(authClient.verifyToken("token")).thenReturn(new AuthResponse("admin", "admin", false));
		ResponseEntity<?> getAllSpecialists=ipTreatmentOfferingsController.getAllSpecialists("token");
		assertEquals(403, getAllSpecialists.getStatusCodeValue());
	}
	
	
}
