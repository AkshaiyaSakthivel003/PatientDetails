package com.example.patientDetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.example.patientDetails.Service.PatientService;

@RestController
@CrossOrigin("http://localhost:3000/")
public class Controller {

	@Autowired
	PatientRepository f1;
	
	@Autowired
	PatientService s1;
	
	@GetMapping("/get")
	public List<Patient> getDetails()
	{
		System.out.println("Retrieved All the Details Present In The Table");
		return f1.findAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteDetails(@PathVariable("id") int id)
	{
		f1.deleteById(id);
		return "Id : "+id+" is deleted";
	}
	
	@PostMapping("/post")
	public String postDetails(@RequestBody Patient b1)
	{
		f1.save(b1);
		return "Data Successfully Saved In The DataBase";
	}
	
	@PutMapping("/put/{id}")
	public Patient updateDetails(@RequestBody Patient b)
	{
		System.out.println("The Changes Made Have Been Successfully Updated");
		return f1.save(b);
	}
	
	@GetMapping("/sort/{field}")
	public Iterable<Patient> sorting(@PathVariable String field){
		return s1.sorting(field);
	}
	@GetMapping("paging/{page}/{size}")
	public Page<Patient> paging(@PathVariable int page,@PathVariable int size){
		return s1.spaging(page,size);
	}
	
	@GetMapping("sortwithpage/{field}/{page}/{size}")
	public Page<Patient> sortpaging(@PathVariable String field,@PathVariable int page,@PathVariable int size){
		return s1.sortingandpaging(field,page,size);
	}
	
	@GetMapping("get/{id}")
	public List<Patient> getId(@PathVariable int id){
	return s1.getId(id);
	}

	@GetMapping("get/{disease}")
	public List<Patient> getDisease(@PathVariable String disease){
	return s1.getDisease(disease);
	}

	@GetMapping("get/{id}/{name}")
	public List<Patient> getIdorname(@PathVariable int id , @PathVariable String name){
	return s1.getIdorname(id, name);
	}

	@PutMapping("/update/{disease}/{name}")
	public String updatePatient(@PathVariable String disease,@PathVariable String name){
	return s1.updatePatient(disease,name)+ "Records UPDATED";
	}
        
}