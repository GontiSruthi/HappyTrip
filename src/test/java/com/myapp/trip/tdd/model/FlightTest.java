package com.myapp.trip.tdd.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.myapp.trip.model.Flight;

public class FlightTest {
	public Flight flightData;

	@BeforeEach
	void setUp() {
		flightData = new Flight(123, "SJ00123", "SJ", "SpiceJet", 30, "Bangalore", "Delhi", "11:00", "13:30", 5600,
				"07-03-2021");
	}

	@AfterEach
	void tearDown() {
		flightData = null;
	}

	@Test
	public void testFlight() {
		assertEquals(123, flightData.getFlight_no());
		assertEquals("SJ00123", flightData.getFlight_name());
		assertEquals("SJ", flightData.getAirline_code());
		assertEquals("SpiceJet", flightData.getAirline_name());
		assertEquals(30, flightData.getCapacity());
		assertEquals("Bangalore", flightData.getFrom_city());
		assertEquals("Delhi", flightData.getTo_city());
		assertEquals("11:00", flightData.getArrival_time());
		assertEquals("13:30", flightData.getDeparture_time());
		assertEquals(5600, flightData.getTicket_cost());
		assertEquals("07-03-2021", flightData.getDate_of_departure());

	}
}
