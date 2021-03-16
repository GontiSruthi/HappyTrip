package com.myapp.trip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myapp.trip.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

	@Query("select f from Flight f where fromCity=?1 and toCity=?2 and dateOfDeparture=?3")
	public Flight findFlights(String source, String destination, String dateOfTravel);

}
