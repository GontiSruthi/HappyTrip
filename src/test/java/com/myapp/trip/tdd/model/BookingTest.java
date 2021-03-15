package com.myapp.trip.tdd.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.myapp.trip.model.Booking;

public class BookingTest {
	public Booking bookingObj;

	@BeforeEach
	void setUp() {

		bookingObj = new Booking(1, "21-03-2021", "09-03-2021", 4500);
	}

	@AfterEach
	void tearDown() {
		bookingObj = null;
	}

	@Test
	public void testFlight() {
		assertEquals(1, bookingObj.getId());
		assertEquals("21-03-2021", bookingObj.getOnBoardingDate());
		assertEquals("09-03-2021", bookingObj.getBookedDate());
		assertEquals(4500, bookingObj.getFare());
	}
}