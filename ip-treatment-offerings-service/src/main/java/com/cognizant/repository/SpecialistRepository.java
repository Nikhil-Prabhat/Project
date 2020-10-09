package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.entity.SpecialistDetails;

@Repository
public interface SpecialistRepository extends JpaRepository<SpecialistDetails, Integer> {

}
