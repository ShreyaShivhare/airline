package com.coforge.training.airline.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@AllArgsConstructor
@Entity
@Table(name="booking")
public class Booking {
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 public Long bookingId;
	 private String flightNumber;
	 private LocalDate departureDate;
	 private LocalDate bookingDate;
     private String emailAddress;
     private String ContactNumber;
  //   private String passengerAge;
     public double total_amount;
     private String passportNumber;
     private int numberOfSeats;
     private int price;
     
     
public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getContactNumber() {
		return ContactNumber;
	}

	public void setContactNumber(String contactNumber) {
		ContactNumber = contactNumber;
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<String> getUserName() {
		return userName;
	}

	public void setUserName(List<String> userName) {
		this.userName = userName;
	}

	public List<String> getUserAge() {
		return userAge;
	}

	public void setUserAge(List<String> userAge) {
		this.userAge = userAge;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public List<String> getSeatId() {
		return seatId;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public void setSeatId(List<String> seatId) {
		this.seatId = seatId;
	}

	//     
//     @Column
//     public boolean booking_cancelled= false;
//     public boolean checked_in= false;
//     public boolean payment_completed=false;
//    
     @ElementCollection(targetClass=String.class)
     private List<String> seatId = new ArrayList<>();
     
     @ElementCollection(fetch = FetchType.LAZY)
     @CollectionTable(name = "UserDetails", joinColumns = @JoinColumn(name = "BookingId") )
      private List<String> userName;
     
     @ElementCollection(fetch = FetchType.LAZY)
     @CollectionTable(name = "userDetails", joinColumns = @JoinColumn(name = "BookingId") )
     private List<String> userAge;
         
	public Booking() {
		super();
	}

	


	
	
}
