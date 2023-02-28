package com.example.patientDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="patient_details")
public class Patient {
	@Id

	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	
	@Column(name="age")
	private int age;
	
	@Column(name="disease")
	private String disease;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public Patient(int id, String name, int age, String disease) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.disease = disease;
	}
	public Patient() {
		
	}
}
