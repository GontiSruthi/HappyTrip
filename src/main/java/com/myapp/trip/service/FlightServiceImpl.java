package com.myapp.trip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.trip.model.Flight;
import com.myapp.trip.repository.FlightRepository;

@RestController
public class FlightService {
	@Autowired
	private FlightRepository flightRepository;

	@GetMapping("/findFlights")
	public List<Flight> findFlights(@RequestParam("source") String source,

			@RequestParam("destination") String destination, @RequestParam("departureDate") String departureDate) {

		List<Flight> flights = flightRepository.findFlights(source, destination, departureDate);
		return flights;

	}

}