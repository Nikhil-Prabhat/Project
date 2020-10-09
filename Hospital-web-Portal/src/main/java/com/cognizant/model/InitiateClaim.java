package com.cognizant.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InitiateClaim {
	private Integer id;
	private String patientname;
	private String ailment;
	private String treatmentPackageName;
	private String insurerName;
}
