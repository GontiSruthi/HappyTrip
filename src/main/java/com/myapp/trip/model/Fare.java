package com.myapp.trip.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Fare {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	int id;

	@Column(name = "business_class_fare", nullable = false)
	int businessClassFare;

	@Column(name = "economy_class_fare", nullable = false)
	int economyClassFare;

	@OneToOne(cascade = { CascadeType.ALL })
	private FlightDetails flight;

	public Fare() {

	}

//	public Fare(int id, int businessClassFare, int economyClassFare, FlightDetails flight) {
//		this.id = id;
//		this.businessClassFare = businessClassFare;
//		this.economyClassFare = economyClassFare;
//		this.flight = flight;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBusinessClassFare() {
		return businessClassFare;
	}

	public void setBusinessClassFare(int businessClassFare) {
		this.businessClassFare = businessClassFare;
	}

	public int getEconomyClassFare() {
		return economyClassFare;
	}

	public void setEconomyClassFare(int economyClassFare) {
		this.economyClassFare = economyClassFare;
	}

	public FlightDetails getFlight() {
		return flight;
	}

	public void setFlight(FlightDetails flight) {
		this.flight = flight;
	}

}
