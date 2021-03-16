package com.myapp.trip.tdd.model;

//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.myapp.trip.model.Passenger;

public class PassengerTest {
	@Test
	public void getPassengerInfo() {
		Passenger passenger = new Passenger();
		passenger.setId(1);
		passenger.setGender("female");
		passenger.setName("saloni");
		passenger.setAge(21);
		passenger.setContact(98765432);

		assertEquals("saloni", passenger.getName());
		assertEquals(21, passenger.getAge());
		assertEquals(1, passenger.getId());
		assertEquals(98765432, passenger.getContact());
		assertEquals("female", passenger.getGender());
	}
}