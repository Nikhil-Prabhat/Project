package com.cognizant.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.entity.IPTreatmentPackages;
import com.cognizant.entity.PackageDetails;
import com.cognizant.entity.SpecialistDetails;


@RunWith(SpringRunner.class)
@SpringBootTest
public class IPTreatmentPackagesServiceImplTest 
{
	@Autowired
	private IPTreatmentService ipTreatmentService;
	
	
	@Test
	public void testGetAllPackages()
	{
		List<IPTreatmentPackages> packages=ipTreatmentService.getAllPackages();
		assertEquals(packages.get(0).getAilmentId(),1);
	}
	
	@Test
	public void testGetPackageByName()
	{
		PackageDetails details=new PackageDetails("Package 1", "ABC", 3500, 4);
		List<IPTreatmentPackages> packages=ipTreatmentService.getPackageByName
				(details.getTreatmentPackageName());
		assertEquals(packages.get(0).getPackageDetails().getTreatmentPackageName(), "Package 1");
	}
	
	@Test
	public void testGetAllSpecialists()
	{
		List<SpecialistDetails> specialistDetails=ipTreatmentService.getAllSpecialists();
		assertEquals(specialistDetails.get(0).getSpecialistId(),1);
	}
	
	
}
