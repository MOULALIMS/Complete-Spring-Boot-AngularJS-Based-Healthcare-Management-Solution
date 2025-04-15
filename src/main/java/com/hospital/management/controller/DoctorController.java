package com.hospital.management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hospital.management.dao.Appointment;
import com.hospital.management.dao.Doctor;
import com.hospital.management.error.GlobalException;
import com.hospital.management.service.AppointmentService;
import com.hospital.management.service.DoctorService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DoctorController {

	@Autowired
    private DoctorService doctorService;
	
	@Autowired
	private AppointmentService appointmentService;
	

    @GetMapping("/doctors/{id}")
    public Optional<Doctor> getDoctorById(@PathVariable Integer id) {
        return doctorService.getDoctorById(id);
    }

    
    @GetMapping("/doctors/{did}/getAppointments")
    public List<Appointment> getDoctorAppointments(@PathVariable Integer did) throws GlobalException {
    	return appointmentService.getAppointmentsByDoctorId(did);
    }
}