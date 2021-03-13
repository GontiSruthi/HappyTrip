package com.myapp.trip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.trip.model.Fare;
import com.myapp.trip.repository.FareRepository;

@Service
public class FareServiceImpl implements FareService {

	@Autowired
	private FareRepository fareRepo;

//	@Override
//	public Boolean save(Fare f) {
//		fareRepo.save(f);
//		return null;
//	}

//	@Override
//	public Fare getFareById(int id) {
//		return fareRepo.findById(id).orElse(null);
//	}
//
//	@Override
//	public List<Fare> getFares() {
//		return fareRepo.findAll();
//	}

//	@Override
//	public void deleteFareById(int id) {
//		fareRepo.deleteById(id);
//	}

	@Override
	public Fare getFareByFlightId(int flight_id) {
		return fareRepo.findByFlightId(flight_id);
	}

}
