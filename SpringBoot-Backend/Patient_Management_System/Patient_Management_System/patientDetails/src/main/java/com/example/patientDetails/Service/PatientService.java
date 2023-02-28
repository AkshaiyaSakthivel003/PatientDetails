package com.example.patientDetails.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.patientDetails.PatientRepository;
import com.example.patientDetails.Patient;
import java.util.List;

@Service
public class PatientService {
	
	@Autowired
	PatientRepository in;
	
	public Iterable<Patient> sorting(String field){
		return in.findAll(Sort.by(field));
	}
	
	public Page <Patient> spaging(int page, int size) {
		Pageable paging=PageRequest.of(page, size);
		return in.findAll(paging);
	}
	
	public Page <Patient> sortingandpaging(String field,int page, int size) {
		Pageable paging=PageRequest.of(page, size).withSort(Sort.by(field));
		return in.findAll(paging);
	}
	
	public List<Patient> getId(int id)	{
		return in.getId(id);
	}

	public List<Patient> getDisease(String disease){
	    return in.getDisease(disease);
	}

	public List<Patient> getIdorname(int id, String name){
		return in.getIdorname(id , name);
	}

	public Integer updatePatient(String disease,String name){
		return in.updatePatient(disease,name);
	}
}
