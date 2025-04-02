package com.hospital.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.management.dao.Doctor;
import com.hospital.management.repository.DoctorRepository;

@Service
public class DoctorServiceImp implements DoctorService{
	
	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	@Override
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}

}
