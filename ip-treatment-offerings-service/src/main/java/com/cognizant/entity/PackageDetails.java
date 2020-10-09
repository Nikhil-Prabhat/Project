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
public class PackageDetails
{
	private String treatmentPackageName;
	private String testDetails;
	private Integer cost;
	private Integer treatmentDuration;
}
