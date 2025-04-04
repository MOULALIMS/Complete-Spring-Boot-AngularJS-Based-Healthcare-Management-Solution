package com.hospital.management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.management.dao.Appointment;
import com.hospital.management.service.AppointmentService;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
	 @Autowired
	 private AppointmentService appointmentService;

	 @GetMapping
	 public List<Appointment> getAllAppointments() {
		 return appointmentService.getAllAppointments();
	 }

	 @GetMapping("/{id}")
	 public Optional<Appointment> getAppointmentById(@PathVariable Integer id) {
		 return appointmentService.getAppointmentById(id);
	 }

	 @PostMapping("/addAppointment")
	 public Appointment addAppointment(@RequestBody Appointment appointment) {
		 return appointmentService.addAppointment(appointment);
	 }

	 @DeleteMapping("/{id}")
	 public void deleteAppointment(@PathVariable Integer id) {
		 appointmentService.deleteAppointment(id);
	 }

	 @GetMapping("/user/{userId}")
	 public List<Appointment> getAppointmentsByUserId(@PathVariable Integer userId) {
		 return appointmentService.getAppointmentsByUserId(userId);
	 }

	 @GetMapping("/doctor/{doctorId}")
	 public List<Appointment> getAppointmentsByDoctorId(@PathVariable Integer doctorId) {
		 return appointmentService.getAppointmentsByDoctorId(doctorId);
	 }	
}
