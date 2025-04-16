package com.hospital.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.management.dao.Prescription;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Integer>{

	List<Prescription> findPrescriptionsByDoctorDoctorId(Integer doctorId);

	List<Prescription> findPrescriptionsByUserUserId(Integer userId);
	
}
