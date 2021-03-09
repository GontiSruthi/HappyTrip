package com.myapp.trip.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.myapp.trip.model.Flight;

@Transactional
@RestResource(path = "flight")
public interface FlightRepository extends JpaRepository<Flight, Integer> {

	@Query("from Flight where from_city=:from_city and to_city=:to_city and date_of_departure=:date_of_departure")
	List<Flight> findFlights(@Param("from_city") String from, @Param("to_city") String to,
			@Param("date_of_departure") String departureDate);
}
