package com.hospital.management.dao;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "patient")
public class Patient extends User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Integer patientID;
    
    @Column(name = "patient_age")
    private Integer patientAge;
    
    @Enumerated(EnumType.STRING)
    private Gender patientGender;
    
    @Column(name = "emergency_contact")
    private String emergencyContact;
    
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = true)
    private Doctor doctor;

    public Patient() {
        super();
    }

    public Patient(String userFirstName, String userMiddleName, String userLastName, String userEmail,
                   String userPassword, String userPhone, Date date, Doctor doctor) {
        super(userFirstName, userMiddleName, userLastName, userEmail, userPassword, userPhone, UserRole.PATIENT, date);
        this.doctor = doctor;
    }

    public Patient(Integer patientAge, Gender patientGender, String emergencyContact, List<Appointment> appointments, Doctor doctor) {
        super();
        this.patientAge = patientAge;
        this.patientGender = patientGender;
        this.emergencyContact = emergencyContact;
        this.appointments = appointments;
        this.doctor = doctor;
    }

    public Integer getPatientID() {
        return patientID;
    }

    public Integer getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(Integer patientAge) {
        this.patientAge = patientAge;
    }

    public Gender getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(Gender patientGender) {
        this.patientGender = patientGender;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
