package com.hospital.management.dao;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonIgnore
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "doctor_id", nullable = false)
	private Doctor doctor;
	
	@Column(name = "appointment_date", nullable = true)
	private LocalDate dateOfAppointment;
	
	@Column(name = "appointment_time", nullable = true)
	private LocalTime appointmentTime;
	
	@Enumerated(EnumType.STRING)
	private AppointmentStatus appointmentStatus;

	
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Appointment(User user, Doctor doctor, LocalDate dateOfAppointment, LocalTime appointmentTime,
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

	public LocalDate getDateOfAppointment() {
		return dateOfAppointment;
	}

	public void setDateOfAppointment(LocalDate dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}

	public LocalTime getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(LocalTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public AppointmentStatus getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}
	
}
