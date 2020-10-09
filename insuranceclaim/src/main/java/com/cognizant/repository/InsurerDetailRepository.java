package com.cognizant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.entity.InsurerDetail;


@Repository
public interface InsurerDetailRepository extends JpaRepository<InsurerDetail, Integer>{
	@Query(value="SELECT * FROM INSURER_DETAIL i where i.INSURER_PACKAGE_NAME=:insurerpackagename"
			,nativeQuery = true)
    public List<InsurerDetail> findByName(@Param("insurerpackagename") String insurerpackagename);
	
	@Query(value="SELECT * FROM INSURER_DETAIL i where i.INSURER_NAME=:insurerName"
			,nativeQuery = true)
	public InsurerDetail findInsurer(@Param("insurerName") String insurerName);

}
