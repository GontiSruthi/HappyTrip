package com.myapp.trip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.trip.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

	public Booking getBookingById(int i);

	public Booking findById(int id);

//	@Override
//	Booking save(Booking b);
	// Booking getBookingById(int id);

}
