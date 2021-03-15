package com.myapp.trip.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myapp.trip.model.Common.PreferredClass;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "on_boarding_date")
	private String onBoardingDate;

	@Column(name = "booked_date")

	private String bookedDate;

	@OneToOne(cascade = { CascadeType.ALL })
	public Passenger passenger;

	@JsonIgnore
	@OneToOne(cascade = { CascadeType.ALL })
	public FlightDetails flight;

	@Column(name = "fare")
	private int fare;

	@Enumerated(EnumType.STRING)
	@Column(name = "preferred_class")
	private PreferredClass preferredClass;

	public Booking() {

	}

	public Booking(int id, String onBoardingDate, String bookedDate, int fare) {
		this.id = id;
		this.onBoardingDate = onBoardingDate;
		this.bookedDate = bookedDate;
		this.fare = fare;
	}

	public Booking(Passenger passenger, FlightDetails flight, String onBoardingDate, int fare,
			PreferredClass preferredClass) {

		this.onBoardingDate = onBoardingDate;
		this.passenger = passenger;
		this.flight = flight;
		this.fare = fare;
		this.preferredClass = preferredClass;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOnBoardingDate() {
		return onBoardingDate;
	}

	public void setOnBoardingDate(String onBoardingDate) {
		this.onBoardingDate = onBoardingDate;
	}

	public String getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(String bookedDate) {
		this.bookedDate = bookedDate;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public FlightDetails getFlight() {
		return flight;
	}

	public void setFlight(FlightDetails flight) {
		this.flight = flight;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public PreferredClass getPreferredClass() {
		return preferredClass;
	}

	public void setPreferredClass(PreferredClass preferredClass) {
		this.preferredClass = preferredClass;
	}

}
