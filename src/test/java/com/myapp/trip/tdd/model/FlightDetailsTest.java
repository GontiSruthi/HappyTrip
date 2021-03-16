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
		booking.setFromCity("Banglore");
		booking.setToCity("Pune");
		booking.setTravelDate("2021-02-24");
		booking.setArrivalTime("12:35:04");
		booking.setAirlineName("IndiaGo");
		booking.setDepartureTime("01:00:00");
		booking.setFlightId(4353);
		booking.setAvailableBusinessSeats(30);
		booking.setAvailableEconomySeats(30);
		assertEquals(101, booking.getId());
		assertEquals("Banglore", booking.getFromCity());
		assertEquals("Pune", booking.getToCity());
		assertEquals("2021-02-24", booking.getTravelDate());
		assertEquals("12:35:04", booking.getArrivalTime());
		assertEquals("01:00:00", booking.getDepartureTime());
		assertEquals("IndiaGo", booking.getAirlineName());
		assertEquals(4353, booking.getFlightId());
		assertEquals(30, booking.getAvailableBusinessSeats());
		assertEquals(30, booking.getAvailableEconomySeats());

	}

}
