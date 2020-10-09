package com.cognizant.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "SpecialistDetails")
public class SpecialistDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer specialistId;
	private String name;
	private String areaOfExpertise;
	private Integer experienceInYears;
	private Long contactNumber;
	
	public SpecialistDetails(String name, String areaOfExpertise, Integer experienceInYears, Long contactNumber) {
		super();
		this.name = name;
		this.areaOfExpertise = areaOfExpertise;
		this.experienceInYears = experienceInYears;
		this.contactNumber = contactNumber;
	}
	
}
