package com.myapp.trip.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

public class PassengerRepositoryTest {
	ProjectionFactory factory = new SpelAwareProxyProjectionFactory();

	@Test
	public void createMapBackedProjection() {
		Passenger passenger = factory.createProjection(Passenger.class);
		passenger.setName("saloni");
		assertEquals(passenger.getName(), "saloni");
	}

	@Test
	public void createsProxyForSourceMap() {
		Map<String, Object> backingMap = new HashMap<>();
		backingMap.put("name", "saloni");
		Passenger passenger = factory.createProjection(Passenger.class, backingMap);
		assertEquals(passenger.getName(), "saloni");
	}

	interface Passenger {
		String getName();

		void setName(String name);
	}
}