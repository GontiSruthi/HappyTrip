package com.myapp.trip.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//@Table(name = "BookingTicket")
public class FlightDetails {

	@Id
	@Column
	private int id;
	@Column
	private String fromCity;
	@Column
	private String toCity;
	@Column
	private String travelDate;
	@Column
	private int flightId;
	@Column
	private String airlineName;
	@Column
	private String departureTime;
	@Column
	private String arrivalTime;
	@Column

	private int availableBusinessSeats = 30;
	@Column
	private int availableEconomySeats = 30;

	public FlightDetails(int id, String fromCity, String toCity, String travelDate, int flightId, String airlineName,
			String departureTime, String arrivalTime, int availableBusinessSeats, int availableEconomySeats) {
		super();
		this.id = id;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.travelDate = travelDate;
		this.flightId = flightId;
		this.airlineName = airlineName;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.availableBusinessSeats = availableBusinessSeats;
		this.availableEconomySeats = availableEconomySeats;
	}

	public FlightDetails() {

	}

	public int getId() {
		return id;
	}

	public String getFromCity() {
		return fromCity;
	}

	public String getToCity() {
		return toCity;
	}

	public String getTravelDate() {
		return travelDate;
	}

	public int getFlightId() {
		return flightId;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public int getAvailableBusinessSeats() {
		return availableBusinessSeats;
	}

	public int getAvailableEconomySeats() {
		return availableEconomySeats;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public void setAvailableBusinessSeats(int availableBusinessSeats) {
		this.availableBusinessSeats = availableBusinessSeats;
	}

	public void setAvailableEconomySeats(int availableEconomySeats) {
		this.availableEconomySeats = availableEconomySeats;
	}

}
