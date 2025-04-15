package com.hospital.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.management.dao.AppointmentStatus;
import com.hospital.management.dao.Receptionist;
import com.hospital.management.service.AppointmentService;
import com.hospital.management.service.StaffService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class StaffController {
	
	@Autowired
	private StaffService staffService;
	
	@Autowired
	private AppointmentService appointmentService;
	
	@GetMapping("/staff/receptionist/{id}")
	public ResponseEntity<Receptionist> getStaffById(@PathVariable Integer Id){
		Receptionist rec = staffService.getStaffById(Id);
		if(rec == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(rec);
	}
	
	@PutMapping("/approve-appointment/{id}")
    public ResponseEntity<String> approveAppointment(@PathVariable Integer id) {
        boolean updated = appointmentService.updateAppointmentStatus(id);
        if (updated) {
            return ResponseEntity.ok("Appointment approved successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Appointment not found");
        }
    }
}
