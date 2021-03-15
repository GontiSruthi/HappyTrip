package com.myapp.trip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.trip.model.Passenger;
import com.myapp.trip.repository.PassengerRepository;

@Service
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private PassengerRepository passengerRepo;

	@Override
	public Boolean save(Passenger c) {
		if (getPassengerByName(c.getName()) == null) {
			passengerRepo.save(c);
			return true;
		}
		return false;
	}

	@Override
	public Passenger getPassengerById(int id) {
		return passengerRepo.findById(id);// .orElse(null);
	}

//	@Override
//	public List<Passenger> getCustomers() {
//		return passengerRepo.findAll();
//	}

	@Override
	public Passenger getPassengerByName(String name) {
		return passengerRepo.findTopByName(name);
	}

}
