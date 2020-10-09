package com.cognizant.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InsurerDetail {
	private Integer insurerId;
	private String insurerName;
	private String insurerPackageName;
	private Integer insuranceAmountLimit;
	private Integer disbursementDuration;
}
