package com.cognizant.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.client.AuthClient;
import com.cognizant.client.InsuranceClient;
import com.cognizant.client.IpTreatmentOfferingsClient;
import com.cognizant.client.TreatmentClient;
import com.cognizant.exception.PackageNotFoundException;
import com.cognizant.model.AuthResponse;
import com.cognizant.model.IPTreatmentPackages;
import com.cognizant.model.InitiateClaim;
import com.cognizant.model.InsurerDetail;
import com.cognizant.model.PDetail;
import com.cognizant.model.PatientDetail;
import com.cognizant.model.SpecialistDetails;
import com.cognizant.model.TreatmentPlan;
import com.cognizant.model.UserLoginCredential;
import com.cognizant.model.UserToken;

@Controller
public class WebController {

	private String token = "";

	@Autowired
	AuthClient authClient;

	@Autowired
	IpTreatmentOfferingsClient offeringsClient;

	@Autowired
	TreatmentClient treatmentClient;

	@Autowired
	InsuranceClient insuranceClient;

	@GetMapping("/login")
	public ModelAndView getLoginPage() {
		return new ModelAndView("login");
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ModelAndView postLogin(@ModelAttribute("userlogin") UserLoginCredential userlogin,
			HttpServletRequest request) {
		UserToken res = null;
		try {
			res = authClient.login(userlogin);
		} catch (Exception e) {
			return new ModelAndView("login");
		}
		request.getSession().setAttribute("token", "Bearer " + res.getAuthToken());
		request.getSession().setAttribute("name", userlogin.getUid());
		return viewAllPackages(request);

	}

	@RequestMapping(path = "/viewallpackages", method = RequestMethod.GET)
	public ModelAndView viewAllPackages(HttpServletRequest request) {
		String token = (String) request.getSession().getAttribute("token");
		String name = (String) request.getSession().getAttribute("name");
		if (token != null) {

			ModelAndView modelandview = new ModelAndView("offerings");

			List<IPTreatmentPackages> allPackages = offeringsClient.getAllPackages(token);
			modelandview.addObject("allPackages", allPackages);
			modelandview.addObject("name", name);
			return modelandview;
		} else {
			return new ModelAndView("login");
		}

	}

	@RequestMapping(path = "/getspecialists", method = RequestMethod.GET)
	public ModelAndView getAllSpecialistes(HttpServletRequest request) {
		String token = (String) request.getSession().getAttribute("token");
		String name = (String) request.getSession().getAttribute("name");
		if (token != null) {
			List<SpecialistDetails> allSpecialists = offeringsClient.getAllSpecialists(token);
			ModelAndView modelandview = new ModelAndView("specialists");
			modelandview.addObject("allspecialists", allSpecialists);
			return modelandview;
		} else {
			return new ModelAndView("login");

		}
	}

	@RequestMapping(path = "/getallpatients", method = RequestMethod.GET)
	public ModelAndView getPatientsPage(HttpServletRequest request) {
		String token = (String) request.getSession().getAttribute("token");
		String name = (String) request.getSession().getAttribute("name");
		if (token != null) {
			List<PatientDetail> allPatients = treatmentClient.getAllPatients(token);
			ModelAndView modelandview = new ModelAndView("patients");
			modelandview.addObject("allPatients", allPatients);
			return modelandview;
		} else {
			return new ModelAndView("login");

		}
	}

	@RequestMapping(path = "/registerpatient", method = RequestMethod.GET)
	public ModelAndView getRegisterPatientsPage(HttpServletRequest request) {
		String token = (String) request.getSession().getAttribute("token");
		String name = (String) request.getSession().getAttribute("name");
		if (token != null) {

			ModelAndView modelandview = new ModelAndView("register-patients");

			return modelandview;
		} else {
			return new ModelAndView("login");

		}
	}

	@RequestMapping(path = "/registerpatient", method = RequestMethod.POST)
	public ModelAndView getTreatmentPlanPage(@ModelAttribute("patient") PDetail patient, HttpServletRequest request)
			throws PackageNotFoundException, ParseException {
		String token = (String) request.getSession().getAttribute("token");
		String name = (String) request.getSession().getAttribute("name");
		if (token != null) {

			TreatmentPlan treatmentPlan = treatmentClient.formulateTreatmentTimetable(token, patient.getName(),
					patient.getAge(), patient.getAilment(), patient.getTreatmentPackageName(),
					patient.getTreatmentCommencementDate());

			ModelAndView modelandview = new ModelAndView("patient-treatment-plan");
			modelandview.addObject("patientdetails", patient);
			modelandview.addObject("treatmentPlan", treatmentPlan);

			return modelandview;
		} else {
			return new ModelAndView("login");

		}
	}

	@RequestMapping(path = "/insurerdetails", method = RequestMethod.GET)
	public ModelAndView getInsurerDetailsPage(HttpServletRequest request) {
		String token = (String) request.getSession().getAttribute("token");
		String name = (String) request.getSession().getAttribute("name");
		if (token != null) {

			List<InsurerDetail> allInsurer = insuranceClient.getAllInsurer(token);
			ModelAndView modelandview = new ModelAndView("insurer-details");
			modelandview.addObject("allInsurer", allInsurer);

			return modelandview;
		} else {
			return new ModelAndView("login");

		}
	}
	
	@RequestMapping(path = "/claiminsurance", method = RequestMethod.GET)
	public ModelAndView getInitiateClaimPage(HttpServletRequest request) {
		String token = (String) request.getSession().getAttribute("token");
		String name = (String) request.getSession().getAttribute("name");
		if (token != null) {

			
			ModelAndView modelandview = new ModelAndView("claim-insurance");
			

			return modelandview;
		} else {
			return new ModelAndView("login");

		}
	}
	@RequestMapping(path = "/claiminsurance", method = RequestMethod.POST)
	public ModelAndView getInitiateClaimData(@ModelAttribute("claim") InitiateClaim claim,HttpServletRequest request) {
		String token = (String) request.getSession().getAttribute("token");
		String name = (String) request.getSession().getAttribute("name");
		if (token != null) {

			int amount = insuranceClient.balanceamounttobepaid(token, claim);
			ModelAndView modelandview = new ModelAndView("insurance");
			modelandview.addObject("initiateclaim", claim);
			modelandview.addObject("amount", amount);

			return modelandview;
		} else {
			return new ModelAndView("login");

		}
	}

	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		session.setAttribute("token", null);
		session.setAttribute("name", null);
		session.invalidate();
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}

}
