package com.hospital.management.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.management.dao.Doctor;
import com.hospital.management.dao.Patient;
import com.hospital.management.error.GlobalException;
import com.hospital.management.repository.DoctorRepository;
import com.hospital.management.repository.PatientRepository;

@Service
public class PatientServiceImp implements PatientService{

	@Autowired
	public PatientRepository patientRepository;
	
	@Autowired
	public DoctorRepository doctorRepository;
	
	@Override
	public Patient savePatient(Patient p) {
			return patientRepository.save(p);
	}

	@Override
	public Patient updatePatient(Integer pid, Integer did) throws GlobalException {
		Optional<Patient> patient = patientRepository.findById(pid);
		if(!patient.isPresent()) {
			throw new GlobalException("Patient Not Found!");
		}
		Optional<Doctor> doctor = doctorRepository.findById(did);
		if(!doctor.isPresent()) {
			throw new GlobalException("Doctor Not Found!");
		}
		Patient p = patient.get();
		p.setDoctor(doctor.get());
		return patientRepository.save(p);
	}

}
