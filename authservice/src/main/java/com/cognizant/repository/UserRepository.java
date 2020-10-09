package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.model.UserTruyum;

@Repository
public interface UserRepository extends JpaRepository<UserTruyum, String> {

}
