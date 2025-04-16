package com.hospital.management.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hospital.management.dao.Appointment;
import com.hospital.management.dao.Prescription;
import com.hospital.management.dao.User;
import com.hospital.management.service.AppointmentService;
import com.hospital.management.service.PrescriptionService;
import com.hospital.management.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
    private UserService userService;
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private PrescriptionService prescriptionService;

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping("/users/addUser")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
    
    // See Prescriptions
    @GetMapping("/users/getPrescriptions/{uid}")
    public ResponseEntity<List<Prescription>> getPrescriptions(@PathVariable Integer uid){
    	List<Prescription> prescriptions = prescriptionService.getPrescriptionsByUserId(uid);
    	return ResponseEntity.ok(prescriptions);
    }
    
    // Add Appointment
    @PostMapping("/users/{uid}/addAppointment/{did}")
	 public Appointment addAppointment(@RequestBody Appointment appointment, @PathVariable Integer uid, @PathVariable Integer did) {
		 return appointmentService.addAppointment(appointment, uid, did);
	 }
}