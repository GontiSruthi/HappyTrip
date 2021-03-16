package com.myapp.trip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.trip.model.Common.PreferredClass;
import com.myapp.trip.model.FlightDetails;
import com.myapp.trip.repository.FlightDetailsRepository;

@Service
public class FlightDetailsServiceImpl implements FlightDetailsService {

	@Autowired
	private FlightDetailsRepository repository;

	@Override
	public FlightDetails getFlightById(int id) {

		return repository.findById(id).orElse(null);
	}

	@Override
	public Boolean checkSeatAvailability(FlightDetails flight, PreferredClass preferredClass) {
		if (preferredClass == PreferredClass.BusinessClass && flight.getAvailableBusinessSeats() <= 0)
			return false;
		else if (flight.getAvailableEconomySeats() <= 0)
			return false;
		else
			return true;
	}

	@Override
	public FlightDetails searchFlight(String fromCity, String toCity, String travelDate) {
		return repository.findBySourceAndDestinationAndDate(fromCity, toCity, travelDate);
	}

	@Override
	public FlightDetails findFlightById(int FlightNo) {

		return repository.findFlightById(FlightNo);
	}

	@Override
	public void updateSeatAvaialability(FlightDetails flight, PreferredClass preferredClass) {
		if (preferredClass == PreferredClass.BusinessClass)
			flight.setAvailableBusinessSeats(flight.getAvailableBusinessSeats() - 1);
		else
			flight.setAvailableEconomySeats(flight.getAvailableEconomySeats() - 1);
		flight = repository.save(flight);

	}

}
