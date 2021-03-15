package com.myapp.trip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.trip.model.Booking;
import com.myapp.trip.model.Common.PreferredClass;
import com.myapp.trip.model.Fare;
import com.myapp.trip.model.FlightDetails;
import com.myapp.trip.model.Passenger;
import com.myapp.trip.repository.BookingRepository;

//import org.apache.logging.log4j.Logger;
@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	private BookingRepository bookingRepo;

	@Autowired
	FlightDetailsService flightService;

	@Autowired
	PassengerService passengerService;

	@Autowired
	FareService fareService;

	@Autowired
	BookingService bookingService;

	@Override
	public Booking save(Booking b) {
		return bookingRepo.save(b);
	}

	@Override
	public Booking getBookingById(int id) {
		return bookingRepo.findById(id);// .orElse(null);
	}
//
//	@Override
//	public List<Booking> getBookings() {
//		return bookingRepo.findAll();
//	}

	@Override
	public Booking confirmBooking(Passenger passenger, FlightDetails flight, String date, PreferredClass preferredClass,
			Fare fare) {
		Booking booked = null;
		passengerService.save(passenger);
		if (preferredClass == PreferredClass.BusinessClass)
			booked = bookingService
					.save(new Booking(passenger, flight, date, fare.getBusinessClassFare(), preferredClass));
		else if (preferredClass == PreferredClass.EconomyClass)
			booked = bookingService
					.save(new Booking(passenger, flight, date, fare.getEconomyClassFare(), preferredClass));

		flightService.updateSeatAvaialability(flight, preferredClass);
		return booked;
	}

}