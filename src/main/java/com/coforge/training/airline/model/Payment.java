package com.coforge.training.airline.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Paymentdetails") //
public class Payment {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long paymentId;
    private Date timestamp = new Date();
    private boolean paymentStatus=true;
    private Double total_amount;
    private String userName;
    private String phoneNumber;
    private String creditCardNumber;
    @DateTimeFormat(pattern = "MM-dd")
    private String expirationDate;
    private String CVV_code;


	public Payment() {
		super();
	}


	public Payment(Long paymentId, Date timestamp, boolean paymentStatus, Double total_amount, String userName,
			String phoneNumber, String creditCardNumber, String expirationDate, String CVV_code) {
		super();
		this.paymentId = paymentId;
		this.timestamp = timestamp;
		this.paymentStatus = paymentStatus;
		this.total_amount = total_amount;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.creditCardNumber = creditCardNumber;
		this.expirationDate = expirationDate;
		this.CVV_code = CVV_code;
	}


	public Long getPaymentId() {
		return paymentId;
	}


	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}


	public Date getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}


	public boolean isPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


	public Double getTotal_amount() {
		return total_amount;
	}


	public void setTotal_amount(Double total_amount) {
		this.total_amount = total_amount;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getCreditCardNumber() {
		return creditCardNumber;
	}


	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}


	public String getExpirationDate() {
		return expirationDate;
	}


	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}


	public String getCVV_code() {
		return CVV_code;
	}


	public void setCVV_code(String cVV_code) {
		CVV_code = cVV_code;
	}


	

   }


