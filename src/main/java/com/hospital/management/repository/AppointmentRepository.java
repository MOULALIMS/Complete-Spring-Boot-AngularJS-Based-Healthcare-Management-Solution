package com.hospital.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.management.dao.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{
	public List<Appointment> findByUserId(Integer userId);

	public List<Appointment> findByDoctorId(Integer doctorId);
}
