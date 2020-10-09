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
public class PackageDetails {
	private String treatmentPackageName;
	private String testDetails;
	private Integer cost;
	private Integer treatmentDuration;

}
