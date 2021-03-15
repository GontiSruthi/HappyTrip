package com.myapp.trip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myapp.trip.model.FlightDetails;

@Repository
public interface FlightDetailsRepository extends JpaRepository<FlightDetails, Integer> {


	// Optional findById(Long flightId);

	@Query("select e from FlightDetails e where from_city=?1 and to_city=?2 and travel_date=?3 ")
	// FlightDetails getDetails(int Flight_no);

	public FlightDetails findBySourceAndDestinationAndDate(String from_city, String to_city, String d);

	@Query("select e from FlightDetails e where Flight_id=?1 ")
	public FlightDetails getFlightById(int i);
	// public void getFlightById(int i);

	public FlightDetails findFlightById(int flight_no);


	// Optional findById(Long flightId);
	@Query("select e from FlightDetails e where from_city=?1 and to_city=?2 and travel_date=?3 ")
	// FlightDetails getDetails(int Flight_no);
	public FlightDetails findBySourceAndDestinationAndDate(String from_city, String to_city, String d);

	@Query("select e from FlightDetails e where Flight_id=?1 ")
	public FlightDetails findFlightById(int flight_no);

	public FlightDetails getFlightById(int i);

	// public void getFlightById(int i);
	// public FlightDetails findFlightById(int flight_no);

}
