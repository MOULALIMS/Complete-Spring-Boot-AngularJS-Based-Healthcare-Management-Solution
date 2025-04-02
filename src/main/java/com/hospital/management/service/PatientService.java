package com.hospital.management.service;

import com.hospital.management.dao.Patient;
import com.hospital.management.error.GlobalException;

public interface PatientService {

	public Patient savePatient(Patient p);

	public Patient updatePatient(Integer pid, Integer did) throws GlobalException;

}
