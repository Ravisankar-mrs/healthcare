package com.slokam.healthcare.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.healthcare.Repo.IPatientRepo;
import com.slokam.healthcare.Repo.PatientCriteriaRepo;
import com.slokam.healthcare.entity.Patient;
import com.slokam.healthcare.pojo.PatientSearchPojo;
@Service
public class IPatientServiceImpl implements IPatientService {
	@Autowired
     private IPatientRepo patientRepo;
	@Autowired
	private PatientCriteriaRepo patientCriteria;
	@Override
	public void patientRegestration(Patient patient) {
		
		patient.setRegdate(new Date());
		patientRepo.save(patient);
		
		
		
	}
	@Override
	public List<Patient> criteriaTest(String name, String email) {
		
		return patientCriteria.patientSearch(name, email);
	}
	@Override
	public List<Patient> patientSearchpojo(PatientSearchPojo searchpojo) {
	
		return patientCriteria.patientFullSearch(searchpojo);
	}
	@Override
	public List<Patient> getAllPatient() {
		
		return patientRepo.findAll();
	}
	@Override
	public Patient getById(Integer id) {
		Optional<Patient>optionalOp=patientRepo.findById(id);
		if(optionalOp.isPresent()) {
			return optionalOp.get();
		}
		return null;
	}

}
