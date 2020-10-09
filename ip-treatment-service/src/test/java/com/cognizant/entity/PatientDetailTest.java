package com.cognizant.entity;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDetailTest 
{
	PatientDetail patientDetail=new PatientDetail();
	
	@Test
	public void testPatientDetailConstructor()
	{
		PatientDetail detail=new PatientDetail(10, "ABC", 50, "XYZ", "Package 10", new Date());
		assertEquals(detail.getName(), "ABC");
	}
	
	@Test
	public void testPatientId()
	{
		patientDetail.setPatientId(20);
		assertEquals(patientDetail.getPatientId(), new Integer(20));
	}
	
	@Test
	public void testName()
	{
		patientDetail.setName("ABC");
		assertEquals(patientDetail.getName(),"ABC");
	}
	
	@Test
	public void testAge()
	{
		patientDetail.setAge(40);
		assertEquals(patientDetail.getAge(), new Integer(40));
	}
	
	
	@Test
	public void testAilment()
	{
		patientDetail.setAilment("XYZ");
		assertEquals(patientDetail.getAilment(),"XYZ");
	}
	
	@Test
	public void testTreatmentPackageName()
	{
		patientDetail.setTreatmentPackageName("MNO");
		assertEquals(patientDetail.getTreatmentPackageName(),"MNO");
	}
	
	@Test
	public void testTreatmentCommencementDate()
	{
		patientDetail.setTreatmentCommencementDate(new Date());
		assertEquals(patientDetail.getTreatmentCommencementDate(), new Date());
	}
	
	@Test
	public void testtoString() 
	{
        String s = patientDetail.toString();
        assertEquals(patientDetail.toString(), s);
    }
}
