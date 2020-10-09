package com.cognizant.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.client.AuthClient;
import com.cognizant.client.AuthResponse;
import com.cognizant.client.IPTreatmentOfferingsClient;
import com.cognizant.entity.PatientDetail;
import com.cognizant.entity.SpecialistDetails;
import com.cognizant.entity.TreatmentPlan;
import com.cognizant.exception.PackageNotFoundException;
import com.cognizant.model.IPTreatmentPackages;
import com.cognizant.model.PackageDetails;
import com.cognizant.repository.PatientDetailRepository;
import com.cognizant.repository.TreatmentPlanRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IPTreatmentServiceImplTest 
{
	@InjectMocks
	private IPTreatmentServiceImpl ipTreatmentServiceImpl;
	
	@Mock
	private PatientDetailRepository patientDetailRepository;
	
	@Mock
	private TreatmentPlanRepository treatmentPlanRepository;
	
	@Mock
	private AuthClient authClient;
	
	@Mock
	private IPTreatmentOfferingsClient ipTreatmentOfferingsClient;
	
	@Mock
	private IPTreatmentPackages ipTreatmentPackages;
	
	@Mock
	private PackageDetails packageDetails;
	
	@Mock
	private SpecialistDetails specialistDetails;
	
	@Mock
	private TreatmentPlan treatmentPlan;
	
	@Mock
	private PatientDetail patientDetail;
	
	@Mock
	private AuthResponse authResponse;
	
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
		
		
		patientDetail.setPatientId(7);
		patientDetail.setName("MNO");
		patientDetail.setAge(50);
		patientDetail.setAilment("XYZ");
		patientDetail.setTreatmentPackageName("ABCD");
		patientDetail.setTreatmentCommencementDate(new Date());
		
		
		treatmentPlan.setTreatmentId(1234);
		treatmentPlan.setPackageName("ABCD");
		treatmentPlan.setTestDetails("XYZ");
		treatmentPlan.setCost(3000);
		treatmentPlan.setSpecialist(specialistDetails);
		treatmentPlan.setTreatmentCommencementDate(new Date());
		treatmentPlan.setTreatmentEndDate(new Date());
		
		
	}
	
	@Test
	public void testFormulateTreatmentTimetable() throws PackageNotFoundException
	{
		List<IPTreatmentPackages> list=new ArrayList<>();
		List<SpecialistDetails> list2=new ArrayList<>();
		list.add(ipTreatmentPackages);
		list2.add(specialistDetails);
		Mockito.when(ipTreatmentOfferingsClient.getPackageByName("token","ABCD")).thenReturn(list);
		Mockito.when(ipTreatmentOfferingsClient.getAllSpecialists("token")).thenReturn(list2);
		
		Mockito.when(patientDetailRepository.save(patientDetail)).thenReturn(patientDetail);
		Mockito.when(treatmentPlanRepository.save(treatmentPlan)).thenReturn(treatmentPlan);
		
		Mockito.when(ipTreatmentServiceImpl.formulateTreatmentTimetable
				("token", "MNO", 50, "XYZ", "ABCD", new Date())).thenReturn(treatmentPlan);
//		assertEquals(ipTreatmentServiceImpl;
	}
}
