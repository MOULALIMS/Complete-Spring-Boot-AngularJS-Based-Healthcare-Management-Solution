package com.hospital.management.service;

import java.util.List;
import java.util.Optional;

import com.hospital.management.dao.Doctor;
import com.hospital.management.error.GlobalException;

public interface DoctorService {
	public List<Doctor> getAllDoctors();

	public List<Doctor> saveDoctors(List<Doctor> doctor) throws GlobalException;

	public Doctor addDoctor(Doctor doctor) throws GlobalException;

	public Optional<Doctor> getDoctorById(Integer id);

	public void deleteDoctor(Integer id);
	
}
