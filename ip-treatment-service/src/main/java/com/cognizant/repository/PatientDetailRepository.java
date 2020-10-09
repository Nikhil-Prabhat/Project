package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.entity.PatientDetail;

@Repository
public interface PatientDetailRepository extends JpaRepository<PatientDetail, Integer> {

	@Query(value="select * from PATIENTDETAIL p where p.NAME=:name and p.TREATMENT_PACKAGE_NAME=:treatmentPackageName",
			nativeQuery = true)
	public PatientDetail getPatient(@Param("name") String name,@Param("treatmentPackageName") String treatmentPackageName);
}
