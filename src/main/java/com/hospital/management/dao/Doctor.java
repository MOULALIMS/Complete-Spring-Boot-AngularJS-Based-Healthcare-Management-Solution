package com.hospital.management.dao;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor extends User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Integer doctorId;
    
    @Column(name = "department_name")
    private String doctorDepartmentName;
    
    @Column(name = "doctor_address")
    private String doctorAddress;
    
    @Column(name = "doctor_age")
    private Integer doctorAge;
    
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Patient> patients;

    public Doctor() {
        super();
    }

    public Doctor(String userFirstName, String userMiddleName, String userLastName, String userEmail, String userPassword,
                  String userPhone, UserRole role, String doctorDepartmentName, String doctorAddress, Integer doctorAge, Date date) {
        super(userFirstName, userMiddleName, userLastName, userEmail, userPassword, userPhone, UserRole.DOCTOR, date);
        this.doctorDepartmentName = doctorDepartmentName;
        this.doctorAddress = doctorAddress;
        this.doctorAge = doctorAge;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public String getDoctorDepartmentName() {
        return doctorDepartmentName;
    }

    public void setDoctorDepartmentName(String doctorDepartmentName) {
        this.doctorDepartmentName = doctorDepartmentName;
    }

    public String getDoctorAddress() {
        return doctorAddress;
    }

    public void setDoctorAddress(String doctorAddress) {
        this.doctorAddress = doctorAddress;
    }

    public Integer getDoctorAge() {
        return doctorAge;
    }

    public void setDoctorAge(Integer doctorAge) {
        this.doctorAge = doctorAge;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public void displayDoctorInfo() {
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Department: " + doctorDepartmentName);
        System.out.println("Address: " + doctorAddress);
        System.out.println("Age: " + doctorAge);
    }
}
