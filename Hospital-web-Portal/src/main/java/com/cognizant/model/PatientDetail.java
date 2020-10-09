package com.cognizant.model;

import java.util.Date;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PatientDetail {
	private Integer patientId;
	private String name;
	private Integer age;
	private String ailment;
	private String treatmentPackageName;
	private Date treatmentCommencementDate;
}
