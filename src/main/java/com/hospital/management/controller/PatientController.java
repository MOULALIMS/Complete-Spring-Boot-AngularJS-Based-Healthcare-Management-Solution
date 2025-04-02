package com.hospital.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hospital.management.dao.Patient;
import com.hospital.management.error.GlobalException;
import com.hospital.management.service.PatientService;

@RestController
@RequestMapping("api/patients")
public class PatientController {
	
	@Autowired
	public PatientService patientService;
	
	@PostMapping("/savePatient")
	public ResponseEntity<Patient> savePatient(@RequestBody Patient p) {
		Patient patient = patientService.savePatient(p);
		return ResponseEntity.status(HttpStatus.CREATED).body(patient);
	}
	
	@PutMapping("/{pid}/doctor/{did}")
	public ResponseEntity<Patient> updatePatient(@PathVariable Integer pid,@PathVariable Integer did) throws GlobalException {
		Patient p = patientService.updatePatient(pid, did);
		return ResponseEntity.ok(p);
	}
}
