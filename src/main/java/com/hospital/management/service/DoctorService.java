package com.hospital.management.service;

import java.util.List;

import com.hospital.management.dao.Doctor;

public interface DoctorService {

	public Doctor saveDoctor(Doctor doctor);

	public List<Doctor> getAllDoctors();

}
