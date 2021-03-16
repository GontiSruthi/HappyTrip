package com.myapp.trip.service;

import com.myapp.trip.model.Fare;

public interface FareService {

	public Fare getFareByFlightId(int flightId);

}
