package com.myapp.trip.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.trip.model.Flight;
import com.myapp.trip.service.FlightService;

@RestController
@RequestMapping("/SearchFlight")
public class FlightController {

	@Autowired
	public FlightService fs;

	@GetMapping(value = "/{enter-source}/{enter-destination}/{enter-dateoftravel}")
	public Flight findFlights(@PathVariable("enter-source") String src, @PathVariable("enter-destination") String dest,
			@PathVariable("enter-dateoftravel") String dot) {
		Flight flightObj = fs.findFlights(src, dest, dot);
		return flightObj;
	}

}
