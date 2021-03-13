package com.myapp.trip.service;

import com.myapp.trip.model.Booking;
import com.myapp.trip.model.Common.PreferredClass;
import com.myapp.trip.model.Fare;
import com.myapp.trip.model.FlightDetails;
import com.myapp.trip.model.Passenger;

public interface BookingService {

	public Booking save(Booking b);

	public Booking getBookingById(int id);

	// public List<Booking> getBookings();

	public Booking confirmBooking(Passenger passenger, FlightDetails flight, String date, PreferredClass preferredClass,
			Fare fare);

}
