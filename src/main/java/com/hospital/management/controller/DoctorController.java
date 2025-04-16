package com.hospital.management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hospital.management.dao.Appointment;
import com.hospital.management.dao.Doctor;
import com.hospital.management.dao.Prescription;
import com.hospital.management.error.GlobalException;
import com.hospital.management.service.AppointmentService;
import com.hospital.management.service.DoctorService;
import com.hospital.management.service.PrescriptionService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DoctorController {

	@Autowired
    private DoctorService doctorService;
	
	@Autowired
	private PrescriptionService prescriptionService;
	
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
    
    // ===================== Prescriptions ========================
    
    // Post or Insert Prescription
    @PostMapping("/doctor/{did}/prescription/{uid}/{aid}")
    public ResponseEntity<Prescription> createPrescription(@PathVariable Integer did, 
    														@PathVariable Integer uid,
    														@PathVariable Integer aid,
    														@RequestBody Prescription prescription){
    	return prescriptionService.createPrescription(did, uid, aid, prescription);
    }
    
    // Update Prescription
    @PutMapping("/doctors/{did}/prescription/{uid}/{aid}")
    public ResponseEntity<Prescription> updatePrescription(@PathVariable Integer did, 
    														@PathVariable Integer uid,
    														@PathVariable Integer aid,
    														@RequestBody Prescription prescription) throws GlobalException{
    	Prescription prescription2 = prescriptionService.updatePrescription(did, uid, aid, prescription);
    	return ResponseEntity.ok(prescription2);
    }
    
    // Get Prescriptions
    @GetMapping("/doctors/{did}/prescriptions")
    public ResponseEntity<List<Prescription>> getPrescriptionsByDoctor(@PathVariable Integer did){
    	List<Prescription> prescriptions = prescriptionService.getPrescriptionsByDoctorId(did);
    	return ResponseEntity.ok(prescriptions);
    }
    
}