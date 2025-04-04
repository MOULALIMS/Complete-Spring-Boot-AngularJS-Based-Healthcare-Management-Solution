package com.hospital.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.management.dao.Appointment;
import com.hospital.management.repository.AppointmentRepository;

@Service
public class AppointmentServiceImp implements AppointmentService{

	 @Autowired
	 private AppointmentRepository appointmentRepository;

	 @Override
	 public List<Appointment> getAllAppointments() {
		 return appointmentRepository.findAll();
	 }

	 @Override
	 public Optional<Appointment> getAppointmentById(Integer id) {
		 return appointmentRepository.findById(id);
	 }

	 @Override
	 public Appointment addAppointment(Appointment appointment) {
		 return appointmentRepository.save(appointment);
	 }
	 
	 @Override
	 public void deleteAppointment(Integer id) {
		 appointmentRepository.deleteById(id);
	 }

	 @Override
	 public List<Appointment> getAppointmentsByUserId(Integer userId) {
		 return appointmentRepository.findByUserId(userId);
	 }

	 @Override
	 public List<Appointment> getAppointmentsByDoctorId(Integer doctorId) {
		 return appointmentRepository.findByDoctorId(doctorId);
	 }
}
