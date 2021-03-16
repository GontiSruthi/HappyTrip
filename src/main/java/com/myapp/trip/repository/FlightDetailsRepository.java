package com.myapp.trip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myapp.trip.model.FlightDetails;

@Repository
public interface FlightDetailsRepository extends JpaRepository<FlightDetails, Integer> {
	@Query("select e from FlightDetails e where fromCity=?1 and toCity=?2 and travelDate=?3 ")
	public FlightDetails findBySourceAndDestinationAndDate(String fromCity, String toCity, String d);

	@Query("select e from FlightDetails e where FlightId=?1 ")
	public FlightDetails findFlightById(int flightNo);

	public FlightDetails getFlightById(int i);

}