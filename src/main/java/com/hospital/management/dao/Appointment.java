package com.hospital.management.dao;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointment")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "appointment_id")
	private Integer appointmentId;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "doctor_id", nullable = false)
	private Doctor doctor;
	
	@Column(name = "appointment_date", nullable = true)
	private Date dateOfAppointment;
	
	@Column(name = "appointment_time", nullable = true)
	private Time appointmentTime;
	
	@Enumerated(EnumType.STRING)
	private AppointmentStatus appointmentStatus;

	
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Appointment(User user, Doctor doctor, Date dateOfAppointment, Time appointmentTime,
			AppointmentStatus appointmentStatus) {
		super();
		this.user = user;
		this.doctor = doctor;
		this.dateOfAppointment = dateOfAppointment;
		this.appointmentTime = appointmentTime;
		this.appointmentStatus = appointmentStatus;
	}


	public Integer getAppointmentID() {
		return appointmentId;
	}
	

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Integer getAppointmentId() {
		return appointmentId;
	}


	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Date getDateOfAppointment() {
		return dateOfAppointment;
	}

	public void setDateOfAppointment(Date dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}

	public Time getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(Time appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public AppointmentStatus getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}
	
}
