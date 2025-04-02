package com.hospital.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.management.dao.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
