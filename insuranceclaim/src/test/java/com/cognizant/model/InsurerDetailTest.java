package com.cognizant.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.entity.InsurerDetail;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = InsurerDetail.class)
public class InsurerDetailTest {
	InsurerDetail insurer = new InsurerDetail();
	
	@Test
	public void testInsurerDetailConstructor()
	{
		InsurerDetail insurerClaim =new InsurerDetail(10, "ABC", "Package 1", 2000,10);
	    assertEquals(insurerClaim.getInsurerName(),"ABC");
	}
	
	@Test
	public void testId()
	{
		insurer.setInsurerId(10);
		assertEquals(insurer.getInsurerId(), new Integer(10));
	}
	@Test
	public void testInsurerName()
	{
		insurer.setInsurerName("ABC");
		assertEquals(insurer.getInsurerName(),"ABC");
	}
	
	
	@Test
	public void testInsurerPackageName()
	{
		insurer.setInsurerPackageName("Package 5");
		assertEquals(insurer.getInsurerPackageName(), "Package 5");
	}
	
	@Test
	public void testInsuranceAmountLimit()
	{
		insurer.setInsuranceAmountLimit(2000);
		assertEquals(insurer.getInsuranceAmountLimit(), new Integer(2000));
	}
	@Test
	public void testDisbursementDuration()
	{
	  insurer.setDisbursementDuration(10);
	  assertEquals(insurer.getDisbursementDuration(),new Integer(10));
	}
	
	@Test
	public void testtoString() 
	{
        String s = insurer.toString();
        assertEquals(insurer.toString(), s);
    }

}
