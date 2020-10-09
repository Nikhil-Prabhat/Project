package com.cognizant.entity;



import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class SpecialistDetails 
{
	private Integer specialistId;
	private String name;
	private String areaOfExpertise;
	private Integer experienceInYears;
	private Long contactNumber;
}
