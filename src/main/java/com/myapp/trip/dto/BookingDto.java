package com.myapp.trip.dto;

import org.springframework.stereotype.Component;

import com.myapp.trip.model.Common.PreferredClass;
import com.myapp.trip.model.Passenger;

@Component
public class BookingDto {

	private Passenger passenger;

	private String source;

	private String destination;

	private String date;

	private PreferredClass preferredClass;

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public PreferredClass getPreferredClass() {
		return preferredClass;
	}

	public void setPreferredClass(PreferredClass preferredClass) {
		this.preferredClass = preferredClass;
	}

}
