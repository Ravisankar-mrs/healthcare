package com.slokam.healthcare.Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.slokam.healthcare.Exception.HealthCareException;
import com.slokam.healthcare.Service.IPatientService;
import com.slokam.healthcare.entity.Patient;
import com.slokam.healthcare.pojo.PatientSearchPojo;


@RestController
@RequestMapping("patient")
public class PatientController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(PatientController.class);
	
	@Autowired
	private IPatientService patientService;
	
	@Value("${app.file.upload.location}")
	private String uploadLocation;
	@PostMapping("/saveImage")
	public ResponseEntity<String> savePatientImage(MultipartFile patientImage)throws HealthCareException{
		String name=System.currentTimeMillis()+"-"+patientImage.getOriginalFilename();
		
			try {
				patientImage.transferTo(new File(uploadLocation+name));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				throw new HealthCareException("Specified file upload loaction is not available", e, 8000);
			}
		
		return new ResponseEntity<String>(name,HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<Patient> registerPatient(@RequestBody Patient patient){
		patientService.patientRegestration(patient);
		return new ResponseEntity<Patient>(patient,HttpStatus.CREATED);
		
	}
	@GetMapping("/criteriaTest/{name}/{email}")
	public ResponseEntity<List<Patient>> criteriaTest(@PathVariable String name,@PathVariable String email) {
		List<Patient> list = patientService.criteriaTest(name, email);
		return new ResponseEntity<List<Patient>>(list,HttpStatus.OK);
	}
	@PostMapping("/search")
	public ResponseEntity<List<Patient>> patientSearch(@RequestBody PatientSearchPojo searchPojo) {
		List<Patient> list=  patientService.patientSearchpojo(searchPojo);
		return ResponseEntity.ok(list);
	}
	@GetMapping("/all")
	public ResponseEntity<List<Patient>> getAllPatient() {
		List<Patient> list=  patientService.getAllPatient();
		return ResponseEntity.ok(list);
	}
	@GetMapping("/ById/{id}")
	public ResponseEntity<Patient> getAllById(@PathVariable Integer id){
		Patient patient=patientService.getById(id);
		return  ResponseEntity.ok(patient);
		
	}
	@GetMapping("/evenpatient")
	public ResponseEntity<List<Patient>> evenpatient() {
//		List<Patient> list=  patientService.getAllPatient();
//		List<Patient>evenlist=	patientService.getAllPatient().stream().filter(patient -> patient.getId()%2==0).collect(Collectors.toList());
		return ResponseEntity.ok( patientService.getAllPatient().stream().filter(patient -> patient.getId()%2==0).collect(Collectors.toList()));
	}
//	@GetMapping("/patientNames")
//	public ResponseEntity<List<Patient>> patienNames() {
//		return ResponseEntity.ok( patientService.getAllPatient().stream().filter(patient -> patient.getName().equals(patient.getName()).collect(Collectors.toList()));
//	}
	public boolean nullCheckForPatient(Patient patient) {
		boolean result=false;
		if(Objects.nonNull(patient)&&patient.getId()!=null&&patient.getId()%2==0) {
			result=true;
		}
		return result;
	}


}
