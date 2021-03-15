package com.myapp.trip.tdd.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

public class FlightDetailsRepositoryTest {
	ProjectionFactory factory = new SpelAwareProxyProjectionFactory();

	@Test
	public void createMapBackedProjection() {
		FlightDetails flight = factory.createProjection(FlightDetails.class);

		flight.setFlight_no(2121);

		assertEquals(flight.getFlight_no(), "2121");
	}

	@Test
	public void createsProxyForSourceMap() {
		Map<String, Object> backingMap = new HashMap<>();

		backingMap.put("Flight_no", 2121);
		FlightDetails flight = factory.createProjection(FlightDetails.class, backingMap);

		assertEquals(flight.getFlight_no(), null);
	}

	interface FlightDetails {

		String getFlight_no();

		void setFlight_no(int Flight_no);
	}

}
