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
public class TreatmentPlan {
	private Integer treatmentId;
	private String packageName;
	private String testDetails;
	private Integer cost;
	private SpecialistDetails specialist;
	private Date treatmentCommencementDate;
	private Date treatmentEndDate;
}
