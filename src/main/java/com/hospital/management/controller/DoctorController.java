package com.hospital.management.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.management.dao.Doctor;
import com.hospital.management.error.GlobalException;
import com.hospital.management.service.DoctorService;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
	
    @Autowired
    public DoctorService doctorService;
	
    @PostMapping("/saveDoctor")  // Your API URL will be /api/doctors/save
    public Doctor saveDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }
    
    @GetMapping("/getDoctors")
    public List<Doctor> getDoctor(){
    	return doctorService.getAllDoctors();
    }
    
    @PostMapping("/saveDoctors")
    public List<Doctor> saveDoctors(@RequestBody List<Doctor> doctor) throws GlobalException{
    	return doctorService.saveDoctors(doctor);
    }

}

