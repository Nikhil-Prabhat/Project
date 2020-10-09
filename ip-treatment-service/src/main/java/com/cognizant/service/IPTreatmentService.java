package com.cognizant.service;


import java.util.Date;
import java.util.List;

import com.cognizant.entity.PatientDetail;
import com.cognizant.entity.TreatmentPlan;
import com.cognizant.exception.PackageNotFoundException;
import com.cognizant.model.InsuranceInfo;

public interface IPTreatmentService 
{
	public TreatmentPlan formulateTreatmentTimetable(String token,String name,int age,String ailment,
			String treatmentPackageName, Date treatmentCommencementDate) throws PackageNotFoundException;
	
	public InsuranceInfo getInsurance(String name,String ailment,String treatmentPackageName);
	
	public List<PatientDetail> getAllPatients();
}
