package com.cognizant.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.entity.IPTreatmentPackages;

@Repository
public interface IPTreatmentRepository extends JpaRepository<IPTreatmentPackages, Integer> {

	@Query(value="select * from IPTREATMENT_PACKAGES p where p.TREATMENT_PACKAGE_NAME=:packageName",
			nativeQuery = true)
	public List<IPTreatmentPackages> findBytreatmentPackageName(@Param("packageName") String packageName);
	
}
