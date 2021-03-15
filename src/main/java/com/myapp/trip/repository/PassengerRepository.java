package com.myapp.trip.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.trip.model.Passenger;

@Transactional
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

	Passenger findTopByName(String name);

	Passenger findById(int id);

}