package com.myapp.trip.tdd.model;

//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
//import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.myapp.trip.model.Fare;
import com.myapp.trip.model.FlightDetails;

public class FareTest {
	@Autowired
	Fare fare;
	@Autowired
	FlightDetails flight;

	@Test
	public void testLogin() {

		Fare fare = new Fare();
		fare.setId(1);
		fare.setBusinessClassFare(5000);
		fare.setEconomyClassFare(8000);
		fare.setFlight(flight);
		assertEquals(1, fare.getId());
		assertEquals(5000, fare.getBusinessClassFare());
		assertEquals(8000, fare.getEconomyClassFare());
		assertEquals(flight, fare.getFlight());

	}

}
