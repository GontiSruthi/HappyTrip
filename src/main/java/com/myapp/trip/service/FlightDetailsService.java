package com.myapp.trip.service;

import com.myapp.trip.model.Common.PreferredClass;
import com.myapp.trip.model.FlightDetails;

public interface FlightDetailsService {

	public FlightDetails findFlightById(int FlightNo);

	public FlightDetails getFlightById(int id);

	public Boolean checkSeatAvailability(FlightDetails flight, PreferredClass preferredClass);

	public void updateSeatAvaialability(FlightDetails flight, PreferredClass preferredClass);

	public FlightDetails searchFlight(String fromCity, String toCity, String travelDate);

}
