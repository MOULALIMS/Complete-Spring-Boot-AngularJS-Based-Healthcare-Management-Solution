package com.hospital.management.service;

import java.util.List;

import com.hospital.management.dao.Doctor;
import com.hospital.management.error.GlobalException;

public interface DoctorService {

	public Doctor saveDoctor(Doctor doctor);

	public List<Doctor> getAllDoctors();

	public List<Doctor> saveDoctors(List<Doctor> doctor) throws GlobalException;

}
