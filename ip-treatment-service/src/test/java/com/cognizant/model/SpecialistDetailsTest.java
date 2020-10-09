package com.cognizant.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpecialistDetailsTest 
{
	SpecialistDetails details=new SpecialistDetails();
	
		
	@Test
	public void testSpecialistDetailsAllConstructor() {
        SpecialistDetails specialistDetails=new SpecialistDetails(12,"ABC", "XYZ", 5, new Long(1234567890));
        assertEquals(specialistDetails.getName(), "ABC");
    }
	
	@Test
	public void testSpecialistId()
	{
		details.setSpecialistId(10);
		assertEquals(details.getSpecialistId(), new Integer(10));
	}
	
	@Test
	public void testName()
	{
		details.setName("ABC");
		assertEquals(details.getName(),"ABC");
	}
	
	@Test
	public void testAreaOfExpertise()
	{
		details.setAreaOfExpertise("ABC");
		assertEquals(details.getAreaOfExpertise(),"ABC");
	}
	
	@Test
	public void testExperienceInYears()
	{
		details.setExperienceInYears(10);
		assertEquals(details.getExperienceInYears(),new Integer(10));
	}
	
	@Test
	public void testContactNumber()
	{
		details.setContactNumber(new Long(1234567890));
		assertEquals(details.getContactNumber(),new Long(1234567890));
	}
	
	@Test
	public void testtoString() 
	{
        String s = details.toString();
        assertEquals(details.toString(), s);
    }
}
	