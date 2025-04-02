package com.hospital.management.dao;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;

@MappedSuperclass
public class User {
	
	@Column(name = "first_name")
	private String FirstName;
	
	@Column(name = "middle_name")
	private String MiddleName;
	
	@Column(name = "last_name")
	private String LastName;
	
	@Column(name = "email_address")
	private String Email;
	
	@Column(name = "password")
	private String Password;
	
	@Column(name = "phone")
	private String Phone;
	
	@Enumerated(EnumType.STRING)
	private UserRole role;
	
	@Column(name = "date_of_birth")
	private Date dateOfBirth;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userFirstName, String userMiddleName, String userLastName, String userEmail, String userPassword,
			String userPhone, UserRole role, Date date) {
		super();
		this.FirstName = userFirstName;
		this.MiddleName = userMiddleName;
		this.LastName = userLastName;
		this.Email = userEmail;
		this.Password = userPassword;
		this.Phone = userPhone;
		this.role = role;
		this.dateOfBirth = date;
	}

	public String getUserFirstName() {
		return FirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.FirstName = userFirstName;
	}

	public String getUserMiddleName() {
		return MiddleName;
	}

	public void setUserMiddleName(String userMiddleName) {
		this.MiddleName = userMiddleName;
	}

	public String getUserLastName() {
		return LastName;
	}

	public void setUserLastName(String userLastName) {
		this.LastName = userLastName;
	}

	public String getUserEmail() {
		return Email;
	}

	public void setUserEmail(String userEmail) {
		this.Email = userEmail;
	}

	public String getUserPassword() {
		return Password;
	}

	public void setUserPassword(String userPassword) {
		this.Password = userPassword;
	}

	public String getUserPhone() {
		return Phone;
	}

	public void setUserPhone(String userPhone) {
		this.Phone = userPhone;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userFirstName=" + FirstName + ", userMiddleName=" + MiddleName + ", userLastName="
				+ LastName + ", userEmail=" + Email + ", userPassword=" + Password + ", userPhone="
				+ Phone + ", role=" + role + "]";
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
}
