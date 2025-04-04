package com.hospital.management.service;

import java.util.List;
import java.util.Optional;

import com.hospital.management.dao.Appointment;

public interface AppointmentService {

	public Optional<Appointment> getAppointmentById(Integer id);

	public List<Appointment> getAllAppointments();

	public Appointment addAppointment(Appointment appointment);

	public void deleteAppointment(Integer id);

	public List<Appointment> getAppointmentsByUserId(Integer userId);

	List<Appointment> getAppointmentsByDoctorId(Integer doctorId);

}
