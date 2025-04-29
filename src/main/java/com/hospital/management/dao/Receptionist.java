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
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "receptionist")
public class Receptionist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "staff_id")
	private Integer Id;
	
	@Column(name = "first_name", nullable = false, length = 10)
	private String firstName;
	
	@Column(name = "middle_name")
	private String middleName;
	
	@Column(name = "last_name", nullable = false, length = 20)
	private String lastName;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "phone", nullable = false, unique = true)
	private String phone;
	
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

	@PrePersist
	protected void onCreate() {
		this.joiningDate = LocalDate.now();
		this.role = UserRole.STAFF;
	}
	
	public Receptionist() {
		super();
	}


	public Receptionist(String staffFirstName, String staffMiddleName, String staffLastName, String staffEmail,
	        String staffPhone, String password, Gender gender, LocalDate joiningDate, String photoURL) {
	    this.firstName = staffFirstName;
	    this.middleName = staffMiddleName;
	    this.lastName = staffLastName;
	    this.email = staffEmail;
	    this.phone = staffPhone;
	    this.password = password;
	    this.gender = gender;
	    this.joiningDate = joiningDate;
	    this.photoURL = photoURL;
	    this.role = UserRole.STAFF;
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


	

	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getId() {
		return Id;
	}
	
	
}
