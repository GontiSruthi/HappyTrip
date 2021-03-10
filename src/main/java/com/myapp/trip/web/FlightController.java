package com.myapp.trip.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.trip.model.Flight;
import com.myapp.trip.service.FlightService;

@RestController
@RequestMapping("/Search")
public class FlightController {

	@Autowired
	FlightService fs;

	@GetMapping(value = "/Flight/{enter-source}/{enter-destination}/{enter-dateoftravel}")
	public String findFlights(@PathVariable("enter-source") String src, @PathVariable("enter-destination") String dest,
			@PathVariable("enter-dateoftravel") String dot) {
		Flight flightObj = fs.findFlights(src, dest, dot);
		if (flightObj != null) {
			return "<style>h1 {color: blue;}marquee {color: green;}h2 {color: Magenta}</style><center><h1>FLIGHT DETAILS</h1> "
					+ "<h2>Available Flights</h2>" + "<strong>Flight No : </strong>" + flightObj.getFlight_no() + "<br>"
					+ "<strong>Flight Name : </strong>" + flightObj.getFlight_name() + "<br>"
					+ "<strong>Airline Code : </strong>" + flightObj.getAirline_code() + "<br>"
					+ "<strong>Airline Name : </strong>" + flightObj.getAirline_name() + "<br>"
					+ "<strong>Capacity : </strong>" + flightObj.getCapacity() + "<br>" + "<strong>Source : </strong>"
					+ flightObj.getFrom_city() + "<br>" + "<strong>Destination : </strong>" + flightObj.getTo_city()
					+ "<br>" + "<strong>Arrival Time : </strong>" + flightObj.getArrival_time() + "<br>"
					+ "<strong>Departure Time : </strong>" + flightObj.getDeparture_time() + "<br>"
					+ "<strong>Ticket Cost : </strong>" + flightObj.getTicket_cost() + "<br>"
					+ "<strong>Date Of travel : </strong>" + flightObj.getDate_of_departure() + "</center>";
		}

		// return response;
		else {
			return "<html><body><style>h1 {color:red;}</style>" + "<center><h1>No Flight Available</h1></center>"
					+ "</body></html>";
		}

		// return flightObj;
	}

}
