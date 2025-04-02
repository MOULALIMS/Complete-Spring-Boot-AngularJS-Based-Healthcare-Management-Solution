package com.hospital.management.repository;

import org.springframework.stereotype.Repository;

import com.hospital.management.dao.Doctor;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
