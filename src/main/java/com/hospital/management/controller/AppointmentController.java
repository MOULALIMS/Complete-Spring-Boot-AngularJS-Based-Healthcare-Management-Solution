package com.hospital.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.management.dao.Appointment;
import com.hospital.management.error.GlobalException;
import com.hospital.management.service.AppointmentService;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	@PostMapping("/{pid}/saveAppointment/{did}")
	public ResponseEntity<Appointment> addAppointment(@PathVariable Integer pid, @PathVariable Integer did) throws GlobalException {
		Appointment app = appointmentService.createAppointment(pid, did);
		return ResponseEntity.status(HttpStatus.CREATED).body(app);
	}
}
