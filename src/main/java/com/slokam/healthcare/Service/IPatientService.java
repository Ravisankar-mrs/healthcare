	package com.slokam.healthcare.Service;

import java.util.List;

import com.slokam.healthcare.entity.Patient;
import com.slokam.healthcare.pojo.PatientSearchPojo;

public interface IPatientService {
	
	public void patientRegestration(Patient patient);

	public java.util.List<Patient> criteriaTest(String name,String email);
	public java.util.List<Patient>patientSearchpojo(PatientSearchPojo searchpojo);
	public List<Patient>getAllPatient();
	public Patient getById(Integer id);
}
