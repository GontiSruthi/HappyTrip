package com.myapp.trip.service;

import com.myapp.trip.model.Common.PreferredClass;
import com.myapp.trip.model.FlightDetails;

public interface FlightDetailsService {

	public FlightDetails findFlightById(int Flight_no);

	public FlightDetails getFlightById(int id);

	public Boolean checkSeatAvailability(FlightDetails flight, PreferredClass preferredClass);

	public void updateSeatAvaialability(FlightDetails flight, PreferredClass preferredClass);

	// public FlightDetails getFlightBySourceAndDestinationAndDate(String from_city,
	// String to_city, Date d);

	public FlightDetails searchFlight(String from_city, String to_city, String travel_date);

}
