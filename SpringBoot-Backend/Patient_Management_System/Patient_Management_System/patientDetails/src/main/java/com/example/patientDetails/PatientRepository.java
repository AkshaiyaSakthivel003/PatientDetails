package com.example.patientDetails;

import org.springframework.stereotype.Repository; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;


@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer>
{
	@Query("select u from Patient u where u.id=:c")
	public List<Patient> getId(@Param("c") int id);

	@Query("select u from Patient u where u.disease=:c")
	public List<Patient> getDisease(@Param("c") String disease);

	@Query("select u from Patient u where u.id=:c or u.name=:a")
	public List<Patient> getIdorname(@Param("c") int id , @Param("a") String name);

	@Modifying
	@Transactional
	@Query("update Patient a set a.disease=:d where a.name=:c")
	public Integer updatePatient(@Param("d") String disease, @Param("c") String name);	
}
