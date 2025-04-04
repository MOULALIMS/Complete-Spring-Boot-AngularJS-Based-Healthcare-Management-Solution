package com.hospital.management.repository;

import org.springframework.stereotype.Repository;

import com.hospital.management.dao.Doctor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	public Optional<Doctor> findByEmail(String email);
}
