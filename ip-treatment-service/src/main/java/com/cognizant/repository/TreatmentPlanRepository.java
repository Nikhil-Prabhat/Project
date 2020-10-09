package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.entity.TreatmentPlan;

@Repository
public interface TreatmentPlanRepository extends JpaRepository<TreatmentPlan, Integer> {

	@Query(value="select * from TREATMENT_PLAN t where t.AREA_OF_EXPERTISE=:ailment and t.PACKAGE_NAME=:packageName",
			nativeQuery = true)
	public TreatmentPlan getTreatmentPlanDetails(@Param("ailment") String ailment,@Param("packageName") String packageName);
}
