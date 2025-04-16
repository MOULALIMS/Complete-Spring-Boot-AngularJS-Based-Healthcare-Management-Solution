package com.hospital.management.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hospital.management.dao.Prescription;
import com.hospital.management.error.GlobalException;

public interface PrescriptionService {

	public ResponseEntity<Prescription> createPrescription(Integer did, Integer uid, Integer aid, Prescription prescription);

	public Prescription updatePrescription(Integer did, Integer uid, Integer aid, Prescription prescription) throws GlobalException;

	public List<Prescription> getPrescriptionsByDoctorId(Integer did);

	public List<Prescription> getPrescriptionsByUserId(Integer uid);

}
