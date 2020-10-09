package com.cognizant.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IPTreatmentPackagesTest 
{
	IPTreatmentPackages ipTreatmentPackages=new IPTreatmentPackages();
	PackageDetails packageDetails=new PackageDetails("Package 5", "ABC", 3000, 5);
	
	@Test
	public void testIPTreatmentPackagesConstructor()
	{
		IPTreatmentPackages packages=new IPTreatmentPackages(10, "ABC", packageDetails);
		assertEquals(packages.getAilmentCategory(), "ABC");
	}
	
	@Test
	public void testAilmentId()
	{
		ipTreatmentPackages.setAilmentId(10);
		assertEquals(ipTreatmentPackages.getAilmentId(), new Integer(10));
	}
	
	@Test
	public void testAilmentCategory()
	{
		ipTreatmentPackages.setAilmentCategory("ABC");
		assertEquals(ipTreatmentPackages.getAilmentCategory(), "ABC");
	}
	
	@Test
	public void testPackageDetails()
	{
		ipTreatmentPackages.setPackageDetails(packageDetails);
		assertEquals(ipTreatmentPackages.getPackageDetails().getTreatmentPackageName(),"Package 5");
	}
	
	@Test
	public void testtoString() 
	{
        String s = ipTreatmentPackages.toString();
        assertEquals(ipTreatmentPackages.toString(), s);
    }
}
