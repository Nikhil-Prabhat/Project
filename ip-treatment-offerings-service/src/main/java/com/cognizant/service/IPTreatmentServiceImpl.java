package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.entity.IPTreatmentPackages;
import com.cognizant.entity.SpecialistDetails;
import com.cognizant.repository.IPTreatmentRepository;
import com.cognizant.repository.SpecialistRepository;

@Service
public class IPTreatmentServiceImpl implements IPTreatmentService {
	
	@Autowired
	private IPTreatmentRepository treatmentrepo;
	
	@Autowired
	private SpecialistRepository specialistrepo;

	@Override
	public List<IPTreatmentPackages> getAllPackages() {
		
		return treatmentrepo.findAll();
	}

	@Override
	public List<IPTreatmentPackages> getPackageByName(String packageName) {
		
		return treatmentrepo.findBytreatmentPackageName(packageName);
	}

	@Override
	public List<SpecialistDetails> getAllSpecialists() {
		
		return specialistrepo.findAll();
	}

}
