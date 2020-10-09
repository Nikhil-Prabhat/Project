package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.entity.InitiateClaim;

@Repository
public interface InitiateClaimRepository extends JpaRepository<InitiateClaim, Integer>{

}
