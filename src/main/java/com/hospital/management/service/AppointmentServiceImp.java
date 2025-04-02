package com.hospital.management.service;

import java.sql.Time;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.management.dao.Appointment;
import com.hospital.management.dao.AppointmentStatus;
import com.hospital.management.dao.Doctor;
import com.hospital.management.dao.Patient;
import com.hospital.management.error.GlobalException;
import com.hospital.management.repository.AppointmentRepository;
import com.hospital.management.repository.DoctorRepository;
import com.hospital.management.repository.PatientRepository;

@Service
public class AppointmentServiceImp implements AppointmentService{
	
	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Override
	public Appointment createAppointment(Integer pid, Integer did) throws GlobalException {
		Optional<Patient> patient = patientRepository.findById(pid);
		if(!patient.isPresent()) {
			throw new GlobalException("Patient Not Found!");
		}
		Optional<Doctor> doctor = doctorRepository.findById(did);
		if(!doctor.isPresent()) {
			throw new GlobalException("Doctor Not Found!");
		}
		Appointment appointment = new Appointment();
		appointment.setAppointmentStatus(AppointmentStatus.APPROVED);
		appointment.setDateOfAppointment(new java.sql.Date(System.currentTimeMillis()));
		appointment.setDoctor(doctor.get());
		appointment.setPatient(patient.get());
		appointment.setAppointmentTime(Time.valueOf("09:00:00"));
		return appointmentRepository.save(appointment);
	}

}
