package com.hospital.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hospital.management.dao.Appointment;
import com.hospital.management.dao.Doctor;
import com.hospital.management.dao.User;
import com.hospital.management.error.RestResponseEntityExceptionHandler;
import com.hospital.management.repository.AppointmentRepository;
import com.hospital.management.repository.DoctorRepository;
import com.hospital.management.repository.UserRepository;

@Service
public class AppointmentServiceImp implements AppointmentService{

    private final RestResponseEntityExceptionHandler restResponseEntityExceptionHandler;

	 @Autowired
	 private AppointmentRepository appointmentRepository;
	 
	 @Autowired
	 private DoctorRepository doctorRepository;
	 
	 @Autowired
	 private UserRepository userRepository;

    AppointmentServiceImp(RestResponseEntityExceptionHandler restResponseEntityExceptionHandler) {
        this.restResponseEntityExceptionHandler = restResponseEntityExceptionHandler;
    }

	 @Override
	 public List<Appointment> getAllAppointments() {
		 return appointmentRepository.findAll();
	 }

	 @Override
	 public Optional<Appointment> getAppointmentById(Integer id) {
		 return appointmentRepository.findById(id);
	 }

	 @Override
	 public Appointment addAppointment(Appointment appointment, Integer userId, Integer doctorId) {
		 Appointment app = new Appointment();
		 app.setDateOfAppointment(appointment.getDateOfAppointment());
		 app.setAppointmentStatus(appointment.getAppointmentStatus());
		 app.setAppointmentTime(appointment.getAppointmentTime());
		 Doctor doctor = doctorRepository.findById(doctorId)
				 .orElseThrow(() -> new RuntimeException("Doctor not found with ID: " + doctorId));

		 // Fetch User
		 User user = userRepository.findById(userId)
				 .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
		 app.setDoctor(doctor);
		 app.setUser(user);
		 return appointmentRepository.save(app);
	 }
	 
	 @Override
	 public void deleteAppointment(Integer id) {
		 appointmentRepository.deleteById(id);
	 }

	 @Override
	 public List<Appointment> getAppointmentsByUserId(Integer userId) {
		 return appointmentRepository.findByUserUserId(userId);
	 }

	 @Override
	 public List<Appointment> getAppointmentsByDoctorId(Integer doctorId) {
		 return appointmentRepository.findByDoctorDoctorId(doctorId);
	 }

}
