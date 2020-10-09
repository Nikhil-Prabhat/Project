package com.cognizant.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.entity.InitiateClaim;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = InitiateClaim.class)
public class InitiateClaimTest {
	InitiateClaim claim= new InitiateClaim();
	
	@Test
	public void testInitiateClaimAllConstructor() {
		InitiateClaim initiateClaim=new  InitiateClaim(1,"abc","XYZ","Package1","ABC");
		 assertEquals(initiateClaim.getPatientname(),"abc");
	}
	
	@Test
	public void testId()
	{
		claim.setId(10);
		assertEquals(claim.getId(),new Integer(10));
	}
	
	@Test
	public void testPatientname()
	{
		claim.setPatientname("abc");
		assertEquals(claim.getPatientname(), "abc");
	}
	
	@Test
	public void testAilment()
	{
		claim.setAilment("XYZ");
		assertEquals(claim.getAilment(), "XYZ");
	}
	
	@Test
	public void testTreatmentpackagename()
	{
		claim.setTreatmentPackageName("Package 1");
		assertEquals(claim.getTreatmentPackageName(), "Package 1");
	}
	
	@Test 
	public void testInsureName()
	{
		claim.setInsurerName("ABC");
		assertEquals(claim.getInsurerName(), "ABC");
	}
	
	@Test
	public void testtoString() 
	{
        String s = claim.toString();
        assertEquals(claim.toString(), s);
    }
	

}
