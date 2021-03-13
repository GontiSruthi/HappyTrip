package com.myapp.trip.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.trip.model.FlightDetails;
import com.myapp.trip.service.FlightDetailsService;

@RestController
@RequestMapping("/flight")
public class FlightDetailsController {
	@Autowired
	public FlightDetailsService fs;

	@GetMapping(value = "/{flightId}")
	public FlightDetails findFlightById(@PathVariable("flightId") int id) {
		FlightDetails flightObj = fs.findFlightById(id);
		return flightObj;
	}
}
