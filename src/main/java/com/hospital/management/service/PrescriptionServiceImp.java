package com.hospital.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hospital.management.dao.Appointment;
import com.hospital.management.dao.AppointmentStatus;
import com.hospital.management.dao.Doctor;
import com.hospital.management.dao.Prescription;
import com.hospital.management.dao.User;
import com.hospital.management.error.GlobalException;
import com.hospital.management.repository.AppointmentRepository;
import com.hospital.management.repository.DoctorRepository;
import com.hospital.management.repository.PrescriptionRepository;
import com.hospital.management.repository.UserRepository;

@Service
public class PrescriptionServiceImp implements PrescriptionService{
	
	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AppointmentRepository appointmentRepository;

	@Override
	public ResponseEntity<Prescription> createPrescription(Integer did, Integer uid, Integer aid, Prescription prescription) {
		Optional<Doctor> doctor = doctorRepository.findById(did);
		if(!doctor.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		Doctor d = doctor.get();
		Optional<User> user = userRepository.findById(uid);
		if(!user.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		Optional<Appointment> aOptional = appointmentRepository.findById(aid);
		if(!aOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		User u = user.get();
		Appointment a = aOptional.get();
		
		if(!a.getAppointmentStatus().equals(AppointmentStatus.APPROVED)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		Prescription p = new Prescription();
		p.setDoctor(d);
		p.setUser(u);
		p.setMedicines(prescription.getMedicines());
		p.setNotes(prescription.getNotes());
		p.setAppointment(a);
		p.setSymptoms(prescription.getSymptoms());
		prescriptionRepository.save(p);
		return ResponseEntity.status(HttpStatus.CREATED).body(p);
	}

	@Override
	public Prescription updatePrescription(Integer did, Integer uid, Integer aid, Prescription prescription) throws GlobalException {
		Optional<Prescription> existing = prescriptionRepository.findById(prescription.getPrescriptionId());
		if(!existing.isPresent()) {
			throw new GlobalException("Prescription not Found!");
		}
		if(!existing.get().getDoctor().getDoctorId().equals(did)) {
			throw new GlobalException("Doctor not authorized to update this prescription");
		}
		if (!existing.get().getUser().getUserId().equals(uid)) {
		    throw new GlobalException("User mismatch: This prescription doesn't belong to the provided user.");
		}
		Prescription p = existing.get();
		p.setAppointment(prescription.getAppointment());
		p.setNotes(prescription.getNotes());
		p.setSymptoms(prescription.getSymptoms());
		return prescriptionRepository.save(p);
	}

	@Override
	public List<Prescription> getPrescriptionsByDoctorId(Integer did) {
		return prescriptionRepository.findPrescriptionsByDoctorDoctorId(did);
	}

	@Override
	public List<Prescription> getPrescriptionsByUserId(Integer uid) {
		return prescriptionRepository.findPrescriptionsByUserUserId(uid);
	}
}
