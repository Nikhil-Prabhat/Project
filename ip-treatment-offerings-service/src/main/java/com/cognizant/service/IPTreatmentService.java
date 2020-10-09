package com.cognizant.service;

import java.util.List;

import com.cognizant.entity.IPTreatmentPackages;
import com.cognizant.entity.SpecialistDetails;

public interface IPTreatmentService 
{
	public List<IPTreatmentPackages> getAllPackages();
	public List<IPTreatmentPackages> getPackageByName(String packageName);
	public List<SpecialistDetails> getAllSpecialists();
}
