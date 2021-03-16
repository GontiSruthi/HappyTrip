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
		assertEquals(123, flightData.getFlightNo());
		assertEquals("SJ00123", flightData.getFlightName());
		assertEquals("SJ", flightData.getAirlineCode());
		assertEquals("SpiceJet", flightData.getAirlineName());
		assertEquals(30, flightData.getCapacity());
		assertEquals("Bangalore", flightData.getFromCity());
		assertEquals("Delhi", flightData.getToCity());
		assertEquals("11:00", flightData.getArrivalTime());
		assertEquals("13:30", flightData.getDepartureTime());
		assertEquals(5600, flightData.getTicketCost());
		assertEquals("07-03-2021", flightData.getDateOfDeparture());

	}
}
