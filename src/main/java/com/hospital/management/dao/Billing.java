package com.hospital.management.dao;

import java.sql.Date;

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
@Table(name = "billing")
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column(name = "bill_date",nullable = false)
    private Date billDate;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod; // Example: "Credit Card", "Cash"

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus; // ENUM (PAID, PENDING, CANCELLED)

    @Column(name = "extra_note")
    private String additionalNotes;

	public Billing() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Billing(Patient patient, Date billDate, Double amount, PaymentMethod paymentMethod, PaymentStatus paymentStatus,
			String additionalNotes) {
		super();
		this.patient = patient;
		this.billDate = billDate;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.paymentStatus = paymentStatus;
		this.additionalNotes = additionalNotes;
	}

	public Long getId() {
		return id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getAdditionalNotes() {
		return additionalNotes;
	}

	public void setAdditionalNotes(String additionalNotes) {
		this.additionalNotes = additionalNotes;
	}

	@Override
	public String toString() {
		return "Billing [id=" + id + ", patient=" + patient + ", billDate=" + billDate + ", amount=" + amount
				+ ", paymentMethod=" + paymentMethod + ", paymentStatus=" + paymentStatus + ", additionalNotes="
				+ additionalNotes + "]";
	}
    
}
