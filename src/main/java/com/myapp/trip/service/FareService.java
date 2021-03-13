package com.myapp.trip.service;

import com.myapp.trip.model.Fare;

public interface FareService {

	// public Boolean save(Fare f);

	// public Fare getFareById(int id);

	// public List<Fare> getFares();

	// public void deleteFareById(int id);

	public Fare getFareByFlightId(int flight_id);

	// public List<Fare> getFareBySourceAndDestinationAndDeparturedate(String
	// source, String destination, Date d);
}
