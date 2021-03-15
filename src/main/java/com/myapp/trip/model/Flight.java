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
	@Column(name = "flight_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flight_no;
	@Column
	private String flight_name;
	@Column
	private String airline_code;
	@Column
	private String airline_name;
	@Column
	private int capacity;
	@Column
	private String from_city;
	@Column
	private String to_city;
	@Column
	private String arrival_time;
	@Column
	private String departure_time;
	@Column
	private double ticket_cost;
	@Column
	private String date_of_departure;

	public Flight() {

	}

	public Flight(int flight_no, String flight_name, String airline_code, String airline_name, int capacity,
			String from_city, String to_city, String arrival_time, String departure_time, double ticket_cost,
			String date_of_departure) {
		super();
		this.flight_no = flight_no;
		this.flight_name = flight_name;
		this.airline_code = airline_code;
		this.airline_name = airline_name;
		this.capacity = capacity;
		this.from_city = from_city;
		this.to_city = to_city;
		this.arrival_time = arrival_time;
		this.departure_time = departure_time;
		this.ticket_cost = ticket_cost;
		this.date_of_departure = date_of_departure;
	}

	public int getFlight_no() {
		return flight_no;
	}

	public String getFlight_name() {
		return flight_name;
	}

	public String getAirline_code() {
		return airline_code;
	}

	public String getAirline_name() {
		return airline_name;
	}

	public int getCapacity() {
		return capacity;
	}

	public String getFrom_city() {
		return from_city;
	}

	public String getTo_city() {
		return to_city;
	}

	public String getArrival_time() {
		return arrival_time;
	}

	public String getDeparture_time() {
		return departure_time;
	}

	public double getTicket_cost() {
		return ticket_cost;
	}

	public String getDate_of_departure() {
		return date_of_departure;
	}

	public void setFrom_city(String from_city) {
		this.from_city = from_city;
	}

	public void setTo_city(String to_city) {
		this.to_city = to_city;
	}

	public void setDate_of_departure(String date_of_departure) {
		this.date_of_departure = date_of_departure;
	}

}