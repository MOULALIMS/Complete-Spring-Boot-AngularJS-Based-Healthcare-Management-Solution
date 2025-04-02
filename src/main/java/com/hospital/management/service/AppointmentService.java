package com.hospital.management.service;

import com.hospital.management.dao.Appointment;
import com.hospital.management.error.GlobalException;

public interface AppointmentService {

	public Appointment createAppointment(Integer pid, Integer did) throws GlobalException;

}
