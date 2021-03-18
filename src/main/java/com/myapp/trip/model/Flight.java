package com.myapp.trip.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Flight")
public class Flight {
	@Id
	@Column(name = "flightNo")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int flightNo;
	@Column
	private String flightName;
	@Column
	private String airlineCode;
	@Column
	private String airlineName;
	@Column
	private int capacity;
	@Column
	private String fromCity;
	@Column
	private String toCity;
	@Column
	private String arrivalTime;
	@Column
	private String departureTime;
	@Column
	private double ticketCost;
	@Column
	private String dateOfDeparture;

	public Flight() {

	}

	public Flight(int flightNo, String flightName, String airlineCode, String airlineName, int capacity,
			String fromCity, String toCity, String arrivalTime, String departureTime, double ticketCost,
			String dateOfDeparture) {
		super();
		this.flightNo = flightNo;
		this.flightName = flightName;
		this.airlineCode = airlineCode;
		this.airlineName = airlineName;
		this.capacity = capacity;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.ticketCost = ticketCost;
		this.dateOfDeparture = dateOfDeparture;
	}

	public int getFlightNo() {
		return flightNo;
	}

	public String getFlightName() {
		return flightName;
	}

	public String getAirlineCode() {
		return airlineCode;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public int getCapacity() {
		return capacity;
	}

	public String getFromCity() {
		return fromCity;
	}

	public String getToCity() {
		return toCity;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public double getTicketCost() {
		return ticketCost;
	}

	public String getDateOfDeparture() {
		return dateOfDeparture;
	}

	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public void setTicketCost(double ticketCost) {
		this.ticketCost = ticketCost;
	}

	public void setDateOfDeparture(String dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}

}