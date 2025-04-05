package com.hospital.management.service;

import java.util.List;
import java.util.Optional;


import com.hospital.management.dao.Appointment;
import com.hospital.management.error.GlobalException;

public interface AppointmentService {

	public Optional<Appointment> getAppointmentById(Integer id);

	public List<Appointment> getAllAppointments();

	public Appointment addAppointment(Appointment appointment, Integer userId, Integer doctorId);

	public void deleteAppointment(Integer id);

	public List<Appointment> getAppointmentsByUserId(Integer userId);

	public List<Appointment> getAppointmentsByDoctorId(Integer doctorId) throws GlobalException;

}
