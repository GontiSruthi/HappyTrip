package com.myapp.trip.service;

import com.myapp.trip.model.Passenger;

public interface PassengerService {

	public Boolean save(Passenger p);

	public Passenger getPassengerById(int id);

	public Passenger getPassengerByName(String name);

}
