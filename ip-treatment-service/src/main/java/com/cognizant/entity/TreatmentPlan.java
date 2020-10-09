package com.cognizant.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



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
@Entity
@Table(name = "TreatmentPlan")
public class TreatmentPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer treatmentId;
	private String packageName;
	private String testDetails;
	private Integer cost;
	private SpecialistDetails specialist;

	private Date treatmentCommencementDate;

	private Date treatmentEndDate;
}
