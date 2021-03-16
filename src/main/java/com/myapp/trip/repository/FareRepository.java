package com.myapp.trip.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.trip.model.Fare;

@Transactional
public interface FareRepository extends JpaRepository<Fare, Integer> {

	public Fare findByFlightId(int flightId);

}
