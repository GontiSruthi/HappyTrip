package com.myapp.trip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myapp.trip.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

	@Query("select f from Flight f where from_city=?1 and to_city=?2 and date_of_departure=?3")
	public Flight findFlights(String source, String destination, String dateOfTravel);

}
