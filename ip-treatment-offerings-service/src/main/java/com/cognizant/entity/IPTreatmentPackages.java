package com.cognizant.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "IPTreatmentPackages")
public class IPTreatmentPackages 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ailmentId;
	private String ailmentCategory;
	
	
	
	PackageDetails packageDetails;
}
