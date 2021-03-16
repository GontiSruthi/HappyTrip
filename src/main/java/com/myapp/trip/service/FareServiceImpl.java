package com.myapp.trip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.trip.model.Fare;
import com.myapp.trip.repository.FareRepository;

@Service
public class FareServiceImpl implements FareService {

	@Autowired
	private FareRepository fareRepo;

	@Override
	public Fare getFareByFlightId(int flightId) {
		return fareRepo.findByFlightId(flightId);
	}

}
