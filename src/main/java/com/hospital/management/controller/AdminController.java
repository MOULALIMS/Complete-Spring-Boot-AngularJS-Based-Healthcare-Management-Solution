package com.hospital.management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hospital.management.dao.Appointment;
import com.hospital.management.dao.Doctor;
import com.hospital.management.dao.User;
import com.hospital.management.error.GlobalException;
import com.hospital.management.service.AppointmentService;
import com.hospital.management.service.DoctorService;
import com.hospital.management.service.UserService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private UserService userService;

    @Autowired
    private AppointmentService appointmentService;

    // ======================== DOCTOR CRUD ==========================

    // Add Multiple Doctors
    @PostMapping("/addDoctors")
    public List<Doctor> addDoctors(@RequestBody List<Doctor> doctor) throws GlobalException{
    	return doctorService.saveDoctors(doctor);
    }
    
    // Get all doctors
    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    // Get doctor by ID
    @GetMapping("/doctors/{id}")
    public Optional<Doctor> getDoctorById(@PathVariable Integer id) {
        return doctorService.getDoctorById(id);
    }

    // Add a new doctor
    @PostMapping("/addDoctor")
    public Doctor addDoctor(@RequestBody Doctor doctor) throws GlobalException {
        return doctorService.addDoctor(doctor);
    }

    // Update a doctor
    @PutMapping("/doctors/{id}")
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
    @DeleteMapping("/doctors/{id}")
    public void deleteDoctor(@PathVariable Integer id) {
        doctorService.deleteDoctor(id);
    }

    // ======================== USERS ==========================

    @PostMapping("/addUsers")
    public List<User> addUsers(@RequestBody List<User> users){
    	return userService.addUsers(users);
    }
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // ======================== APPOINTMENTS ==========================

    // Get all appointments
    @GetMapping("/appointments")
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    // Get appointments by doctor ID
    @GetMapping("/appointments/doctor/{doctorId}")
    public List<Appointment> getAppointmentsByDoctorId(@PathVariable Integer doctorId) throws GlobalException {
        return appointmentService.getAppointmentsByDoctorId(doctorId);
    }

    // Get appointments by user ID
    @GetMapping("/appointments/user/{userId}")
    public List<Appointment> getAppointmentsByUserId(@PathVariable Integer userId) {
        return appointmentService.getAppointmentsByUserId(userId);
    }
}
