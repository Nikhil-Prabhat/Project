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
public class IPTreatmentPackages 
{
	private Integer ailmentId;
	private String ailmentCategory;
	private PackageDetails packageDetails;
}
