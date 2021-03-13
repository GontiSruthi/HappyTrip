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
		if (preferredClass == PreferredClass.BusinessClass && flight.getAvailable_business_seats() <= 0)
			return false;
		else if (flight.getAvailable_economy_seats() <= 0)
			return false;
		else
			return true;
	}

//	@Override
//	public FlightDetails getFlightBySourceAndDestinationAndDate(String from_city, String to_city, Date d) {
//		return flightRepo.findBySourceAndDestinationAndDate(from_city, to_city, d);
//	}

	@Override
	public FlightDetails searchFlight(String from_city, String to_city, String travel_date) {
		return repository.findBySourceAndDestinationAndDate(from_city, to_city, travel_date);
	}

	@Override
	public FlightDetails findFlightById(int Flight_no) {

		return repository.findFlightById(Flight_no);
	}

	@Override
	public void updateSeatAvaialability(FlightDetails flight, PreferredClass preferredClass) {
		if (preferredClass == PreferredClass.BusinessClass)
			flight.setAvailable_business_seats(flight.getAvailable_business_seats() - 1);
		else
			flight.setAvailable_economy_seats(flight.getAvailable_economy_seats() - 1);
		flight = repository.save(flight);

	}

}
