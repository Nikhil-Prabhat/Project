package com.cognizant.entity;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TreatmentPlanTest 
{
	TreatmentPlan treatmentPlan=new TreatmentPlan();
	SpecialistDetails specialistDetails=new SpecialistDetails(10, "ABC", "XYZ", 4, new Long(1234567890));
	
	@Test
	public void testTreatmentPlanConstructor()
	{
		TreatmentPlan plan=new TreatmentPlan(8, "Package 6", "ABCD", 3000, specialistDetails, 
				new Date(), new Date());
		assertEquals(plan.getPackageName(), "Package 6");
	}
	
	@Test
	public void testTreatmentId()
	{
		treatmentPlan.setTreatmentId(15);
		assertEquals(treatmentPlan.getTreatmentId(), new Integer(15));
	}
	@Test
	public void testPackageName()
	{
		treatmentPlan.setPackageName("ABC");
		assertEquals(treatmentPlan.getPackageName(), "ABC");
	}
	
	@Test
	public void testTestDetails()
	{
		treatmentPlan.setTestDetails("XYZ");
		assertEquals(treatmentPlan.getTestDetails(), "XYZ");
	}
	
	@Test
	public void testCost()
	{
		treatmentPlan.setCost(3000);
		assertEquals(treatmentPlan.getCost(), new Integer(3000));
	}
	
	@Test
	public void testSpecialist()
	{
		treatmentPlan.setSpecialist(specialistDetails);
		assertEquals(treatmentPlan.getSpecialist().getName(),"ABC");
	}
	
	@Test
	public void testTreatmentCommencementDate()
	{
		treatmentPlan.setTreatmentCommencementDate(new Date());
		assertEquals(treatmentPlan.getTreatmentCommencementDate(),new Date());
	}
	
	@Test
	public void testTreatmentEndDate()
	{
		treatmentPlan.setTreatmentEndDate(new Date());
		assertEquals(treatmentPlan.getTreatmentEndDate(),new Date());
	}
	
	@Test
	public void testtoString() 
	{
        String s = treatmentPlan.toString();
        assertEquals(treatmentPlan.toString(), s);
    }
}
