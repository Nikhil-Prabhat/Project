package com.cognizant.model;



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
public class SpecialistDetails 
{
	private Integer specialistId;
	private String name;
	private String areaOfExpertise;
	private Integer experienceInYears;
	private Long contactNumber;
}
