package com.cognizant.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.client.IPTreatmentOfferingsClient;
import com.cognizant.entity.PatientDetail;
import com.cognizant.entity.TreatmentPlan;
import com.cognizant.exception.PackageNotFoundException;
import com.cognizant.model.IPTreatmentPackages;
import com.cognizant.model.InsuranceInfo;
import com.cognizant.entity.SpecialistDetails;
import com.cognizant.repository.PatientDetailRepository;
import com.cognizant.repository.TreatmentPlanRepository;

@Service
public class IPTreatmentServiceImpl implements IPTreatmentService {
	

	@Autowired
	private IPTreatmentOfferingsClient client;

	@Autowired
	private PatientDetailRepository patientrepo;

	@Autowired
	private TreatmentPlanRepository treatmentrepo;
	
	

	@Override
	public TreatmentPlan formulateTreatmentTimetable(String token,String name, int age, String ailment, String treatmentPackageName,
			Date treatmentCommencementDate) throws PackageNotFoundException {
		
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		  String strDate= formatter.format(treatmentCommencementDate);  
		
		PatientDetail detail = new PatientDetail();
		detail.setName(name);
		detail.setAge(age);
		detail.setAilment(ailment);
		detail.setTreatmentPackageName(treatmentPackageName);
		detail.setTreatmentCommencementDate(treatmentCommencementDate);

		patientrepo.save(detail);

		TreatmentPlan plan = new TreatmentPlan();
		List<IPTreatmentPackages> packageByName = client.getPackageByName(token,treatmentPackageName);
		
		
		for (IPTreatmentPackages packages : packageByName) {

			if (packages.getAilmentCategory().equalsIgnoreCase(ailment)) {
				plan.setPackageName(packages.getPackageDetails().getTreatmentPackageName());
				plan.setTestDetails(packages.getPackageDetails().getTestDetails());
				plan.setCost(packages.getPackageDetails().getCost());
				plan.setTreatmentCommencementDate(treatmentCommencementDate);
				Calendar c = Calendar.getInstance();
				c.setTime(treatmentCommencementDate);
				c.add(Calendar.DATE, (packages.getPackageDetails().getTreatmentDuration()*7));
				Date endDate = c.getTime();
				plan.setTreatmentEndDate(endDate);
			}
		}
		
		List<SpecialistDetails> allSpecialists = client.getAllSpecialists(token);

		if (treatmentPackageName.equalsIgnoreCase("Package 1")) {
			int min = Integer.MAX_VALUE;
			for (SpecialistDetails details : allSpecialists) {
				if (details.getAreaOfExpertise().equalsIgnoreCase(ailment)) {
					if (min > details.getExperienceInYears()) {
						min = details.getExperienceInYears();
					}
				}
			}
			for (SpecialistDetails details : allSpecialists) {
				if (details.getAreaOfExpertise().equalsIgnoreCase(ailment)) {
					if (min == details.getExperienceInYears()) {
						plan.setSpecialist(details);
					}
				}
			}

		} else {
			int max = Integer.MIN_VALUE;
			for (SpecialistDetails details : allSpecialists) {
				if (details.getAreaOfExpertise().equalsIgnoreCase(ailment)) {
					if (max < details.getExperienceInYears()) {
						max = details.getExperienceInYears();
					}
				}
			}
			for (SpecialistDetails details : allSpecialists) {
				if (details.getAreaOfExpertise().equalsIgnoreCase(ailment)) {
					if (max == details.getExperienceInYears()) {
						plan.setSpecialist(details);
					}
				}
			}
		}

		treatmentrepo.save(plan);
		return plan;
	}



	@Override
	public InsuranceInfo getInsurance(String name, String ailment,String treatmentPackageName) {
		PatientDetail patient = patientrepo.getPatient(name, treatmentPackageName);
		TreatmentPlan treatmentPlanDetails = treatmentrepo.getTreatmentPlanDetails(ailment,treatmentPackageName);
		InsuranceInfo insuranceInfo=new InsuranceInfo();
		insuranceInfo.setName(patient.getName());
		insuranceInfo.setAge(patient.getAge());
		insuranceInfo.setAilment(patient.getAilment());
		insuranceInfo.setCost(treatmentPlanDetails.getCost());
		insuranceInfo.setTreatmentPackageName(treatmentPlanDetails.getPackageName());
		return insuranceInfo;
	}



	@Override
	public List<PatientDetail> getAllPatients() {
		return patientrepo.findAll();
		
	}

}
