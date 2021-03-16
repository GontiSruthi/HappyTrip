package com.myapp.trip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.trip.model.Flight;
import com.myapp.trip.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightRepository flightRepository;

	@Override
	public Flight findFlights(String source, String destination, String dateOfTravel) {

		return flightRepository.findFlights(source, destination, dateOfTravel);
	}

}