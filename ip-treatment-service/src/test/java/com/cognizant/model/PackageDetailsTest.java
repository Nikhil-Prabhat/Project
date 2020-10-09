package com.cognizant.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PackageDetailsTest 
{
	PackageDetails details=new PackageDetails();
	
	@Test
	public void testPackageDetailsConstructor() {
        PackageDetails packageDetails=new PackageDetails("Package 5", "ABC", 3000, 5);
        assertEquals(packageDetails.getTreatmentPackageName(), "Package 5");
    }
	
	@Test
	public void testTreatmentPackageName()
	{
		details.setTreatmentPackageName("Package 3");
		assertEquals(details.getTreatmentPackageName(), "Package 3");
	}
	
	@Test
	public void testTestDetails()
	{
		details.setTestDetails("OPT1,0PT3");
		assertEquals(details.getTestDetails(), "OPT1,0PT3");
	}
	
	@Test
	public void testCost()
	{
		details.setCost(3000);
		assertEquals(details.getCost(), new Integer(3000));
	}
	
	@Test
	public void testTreatmentDuration()
	{
		details.setTreatmentDuration(4);
		assertEquals(details.getTreatmentDuration(),new Integer(4));
	}
	
	@Test
	public void testtoString() 
	{
        String s = details.toString();
        assertEquals(details.toString(), s);
    }
	
	
}
