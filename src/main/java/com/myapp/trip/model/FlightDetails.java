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
	private String from_city;
	@Column
	private String to_city;
	@Column
	private String travel_date;
	@Column
	private int Flight_id;
	@Column
	private String Airline_name;
	@Column
	private String Departure_time;
	@Column
	private String Arrival_time;
	@Column
	private int available_business_seats = 30;
	@Column
	private int available_economy_seats = 30;

	public FlightDetails(int id, String from_city, String to_city, String travel_date, int flight_id,
			String airline_name, String departure_time, String arrival_time, int available_business_seats,
			int available_economy_seats) {
		this.id = id;
		this.from_city = from_city;
		this.to_city = to_city;
		this.travel_date = travel_date;
		Flight_id = flight_id;
		Airline_name = airline_name;
		Departure_time = departure_time;
		Arrival_time = arrival_time;
		this.available_business_seats = available_business_seats;
		this.available_economy_seats = available_economy_seats;
	}

	public FlightDetails() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFrom_city() {
		return from_city;
	}

	public void setFrom_city(String from_city) {
		this.from_city = from_city;
	}

	public String getTo_city() {
		return to_city;
	}

	public void setTo_city(String to_city) {
		this.to_city = to_city;
	}

	public String getTravel_date() {
		return travel_date;
	}

	public void setTravel_date(String travel_date) {
		this.travel_date = travel_date;
	}

	public int getFlight_id() {
		return Flight_id;
	}

	public void setFlight_id(int flight_id) {
		Flight_id = flight_id;
	}

	public String getAirline_name() {
		return Airline_name;
	}

	public void setAirline_name(String airline_name) {
		Airline_name = airline_name;
	}

	public String getDeparture_time() {
		return Departure_time;
	}

	public void setDeparture_time(String departure_time) {
		Departure_time = departure_time;
	}

	public String getArrival_time() {
		return Arrival_time;
	}

	public void setArrival_time(String arrival_time) {
		Arrival_time = arrival_time;
	}

	public int getAvailable_business_seats() {
		return available_business_seats;
	}

	public void setAvailable_business_seats(int available_business_seats) {
		this.available_business_seats = available_business_seats;
	}

	public int getAvailable_economy_seats() {
		return available_economy_seats;
	}

	public void setAvailable_economy_seats(int available_economy_seats) {
		this.available_economy_seats = available_economy_seats;
	}

}
