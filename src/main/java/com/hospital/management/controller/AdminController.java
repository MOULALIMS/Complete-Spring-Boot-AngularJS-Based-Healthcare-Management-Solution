package com.hospital.management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hospital.management.dao.Appointment;
import com.hospital.management.dao.Doctor;
import com.hospital.management.dao.Receptionist;
import com.hospital.management.dao.User;
import com.hospital.management.error.GlobalException;
import com.hospital.management.service.AppointmentService;
import com.hospital.management.service.DoctorService;
import com.hospital.management.service.StaffService;
import com.hospital.management.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private UserService userService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private StaffService staffService;
    
    // ======================== DOCTOR CRUD ==========================

    // Add Multiple Doctors
    @PostMapping("/admin/addDoctors")
    public List<Doctor> addDoctors(@RequestBody List<Doctor> doctor) throws GlobalException{
    	return doctorService.saveDoctors(doctor);
    }
    
    // Get all doctors
    @GetMapping("/admin/doctors")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    // Get doctor by ID
    @GetMapping("/admin/doctors/{id}")
    public Optional<Doctor> getDoctorById(@PathVariable Integer id) {
        return doctorService.getDoctorById(id);
    }

    // Add a new doctor
    @PostMapping("/admin/addDoctor")
    public Doctor addDoctor(@RequestBody Doctor doctor) throws GlobalException {
        return doctorService.addDoctor(doctor);
    }

    // Update a doctor
    @PutMapping("/admin/doctors/{id}")
    public Doctor updateDoctor(@PathVariable Integer id, @RequestBody Doctor updatedDoctor) throws GlobalException {
        Optional<Doctor> existing = doctorService.getDoctorById(id);
        if (existing.isPresent()) {
            Doctor doctor = existing.get();
            doctor.setFirstName(updatedDoctor.getFirstName());
            doctor.setLastName(updatedDoctor.getLastName());
            doctor.setMiddleName(updatedDoctor.getMiddleName());
            doctor.setPhone(updatedDoctor.getPhone());
            doctor.setExperienceYears(updatedDoctor.getExperienceYears());
            doctor.setQualifications(updatedDoctor.getQualifications());
            doctor.setSpecialization(updatedDoctor.getSpecialization());
            
            return doctorService.addDoctor(doctor);
        } else {
            throw new RuntimeException("Doctor not found with id " + id);
        }
    }

    // Delete doctor
    @DeleteMapping("/admin/doctors/{id}")
    public void deleteDoctor(@PathVariable Integer id) {
        doctorService.deleteDoctor(id);
    }

    // ======================== USERS ==========================

    @PostMapping("/admin/addUsers")
    public List<User> addUsers(@RequestBody List<User> users){
    	return userService.addUsers(users);
    }
    @GetMapping("/admin/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // ======================== APPOINTMENTS ==========================

    // Get all appointments
    @GetMapping("/admin/appointments")
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    // Get appointments by doctor ID
    @GetMapping("/admin/appointments/doctor/{doctorId}")
    public List<Appointment> getAppointmentsByDoctorId(@PathVariable Integer doctorId) throws GlobalException {
        return appointmentService.getAppointmentsByDoctorId(doctorId);
    }

    // Get appointments by user ID
    @GetMapping("/admin/appointments/user/{userId}")
    public List<Appointment> getAppointmentsByUserId(@PathVariable Integer userId) {
        return appointmentService.getAppointmentsByUserId(userId);
    }
    
    // ======================== STAFF ==========================
    
    // Get all Staff
    @GetMapping("/admin/staff")
    public List<Receptionist> getAllStaff(){
		return staffService.getAllStaff();    	
    }
    
    // Save multiple Staff
    @PostMapping("/admin/addStaffs")
    public List<Receptionist> saveStaffs(@RequestBody List<Receptionist> receptionists){
    	return staffService.saveAllStaff(receptionists);
    }
    // Save New Staff
    @PostMapping("/admin/addStaff")
    public Receptionist saveStaff(@RequestBody Receptionist receptionist) {
    	return staffService.saveStaff(receptionist);
    }
    
    // Delete Staff by Id
    @DeleteMapping("admin/deleteStaff/{id}")
    public ResponseEntity<String> deleteStaff(@PathVariable Integer id) throws GlobalException{
    	try {
    		staffService.deleteStaff(id);
    		return ResponseEntity.ok("Staff with ID " + id + " deleted successfully.");
    	}catch (RuntimeException e) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
    }
}
