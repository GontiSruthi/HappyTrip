package com.myapp.trip.service;

import com.myapp.trip.model.Flight;

public interface FlightService {

	public Flight findFlights(String src, String dest, String dot);

	Iterable<Flight> findAll();
}
