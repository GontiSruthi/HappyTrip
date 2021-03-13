package com.myapp.trip.tdd.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.myapp.trip.model.FlightDetails;

public class FlightDetailsTest {

	@Autowired
	public FlightDetails booking;

	@Test
	public void testBookingTicket() {

		booking = new FlightDetails(101, "Banglore", "Pune", "2021-02-24", 4353, "IndiaGo", "01:00:00", "12:35:04", 30,
				30);
		booking.setId(101);
		booking.setFrom_city("Banglore");
		booking.setTo_city("Pune");
		booking.setTravel_date("2021-02-24");
		booking.setArrival_time("12:35:04");
		booking.setAirline_name("IndiaGo");
		booking.setDeparture_time("01:00:00");
		booking.setFlight_id(4353);
		booking.setAvailable_business_seats(30);
		booking.setAvailable_economy_seats(30);
		assertEquals(101, booking.getId());
		assertEquals("Banglore", booking.getFrom_city());
		assertEquals("Pune", booking.getTo_city());
		assertEquals("2021-02-24", booking.getTravel_date());
		assertEquals("12:35:04", booking.getArrival_time());
		assertEquals("01:00:00", booking.getDeparture_time());
		assertEquals("IndiaGo", booking.getAirline_name());
		assertEquals(4353, booking.getFlight_id());
		assertEquals(30, booking.getAvailable_business_seats());
		assertEquals(30, booking.getAvailable_economy_seats());

	}

}