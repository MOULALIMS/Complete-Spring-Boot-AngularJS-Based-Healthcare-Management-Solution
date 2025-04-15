package com.hospital.management.dao;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "receptionist")
public class Receptionist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "staff_id")
	private Integer staffId;
	
	@Column(name = "first_name", nullable = false, length = 10)
	private String staffFirstName;
	
	@Column(name = "middle_name")
	private String staffMiddleName;
	
	@Column(name = "last_name", nullable = false, length = 20)
	private String staffLastName;
	
	@Column(name = "email", nullable = false, unique = true)
	private String staffEmail;
	
	@Column(name = "phone", nullable = false, unique = true)
	private String staffPhone;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "gender")
	private Gender gender;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "joining_date")
	private LocalDate joiningDate;
	
	@Column(name = "photoURL")
	private String photoURL;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private UserRole role;

	
	public Receptionist() {
		super();
		this.role = UserRole.STAFF;
	}


	public Receptionist(String staffFirstName, String staffMiddleName, String staffLastName, String staffEmail,
	        String staffPhone, String password, Gender gender, LocalDate joiningDate, String photoURL) {
	    this.staffFirstName = staffFirstName;
	    this.staffMiddleName = staffMiddleName;
	    this.staffLastName = staffLastName;
	    this.staffEmail = staffEmail;
	    this.staffPhone = staffPhone;
	    this.password = password;
	    this.gender = gender;
	    this.joiningDate = joiningDate;
	    this.photoURL = photoURL;
	    this.role = UserRole.STAFF;
	}


	public String getStaffFirstName() {
		return staffFirstName;
	}


	public void setStaffFirstName(String staffFirstName) {
		this.staffFirstName = staffFirstName;
	}


	public String getStaffMiddleName() {
		return staffMiddleName;
	}


	public void setStaffMiddleName(String staffMiddleName) {
		this.staffMiddleName = staffMiddleName;
	}


	public String getStaffLastName() {
		return staffLastName;
	}


	public void setStaffLastName(String staffLastName) {
		this.staffLastName = staffLastName;
	}


	public String getStaffEmail() {
		return staffEmail;
	}


	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}


	public String getStaffPhone() {
		return staffPhone;
	}


	public void setStaffPhone(String staffPhone) {
		this.staffPhone = staffPhone;
	}


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	public LocalDate getJoiningDate() {
		return joiningDate;
	}


	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}


	public String getPhotoURL() {
		return photoURL;
	}


	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}


	public UserRole getRole() {
		return role;
	}


	public void setRole(UserRole role) {
		this.role = role;
	}


	public Integer getStaffId() {
		return staffId;
	}

	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Receptionist [staffId=" + staffId + ", staffFirstName=" + staffFirstName + ", staffMiddleName="
				+ staffMiddleName + ", staffLastName=" + staffLastName + ", staffEmail=" + staffEmail + ", staffPhone="
				+ staffPhone + ", gender=" + gender + ", joiningDate=" + joiningDate + ", photoURL=" + photoURL
				+ ", role=" + role + "]";
	}
	
	
}
