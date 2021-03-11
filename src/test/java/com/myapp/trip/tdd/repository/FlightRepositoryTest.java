package com.myapp.trip.tdd.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

@SpringBootTest
public class FlightRepositoryTest {

	ProjectionFactory factory = new SpelAwareProxyProjectionFactory();

	@Test
	public void createMapBackedProjection() {

		Flight flight = factory.createProjection(Flight.class);

		flight.setFrom_city("Bangalore");
		flight.setTo_city("Delhi");
		flight.setDate_of_departure("09-03-2021");

		assertEquals(flight.getFrom_city(), "Bangalore");
		assertEquals(flight.getTo_city(), "Delhi");
		assertEquals(flight.getDate_of_departure(), "09-03-2021");
	}

	@Test
	public void createsProxyForSourceMap() {

		Map<String, Object> backingMap = new HashMap<>();
		backingMap.put("from_city", "Bangalore");
		backingMap.put("to_city", "Delhi");
		backingMap.put("date_of_departure", "09-03-2021");

		Flight flight = factory.createProjection(Flight.class, backingMap);

		assertEquals(flight.getFrom_city(), "Bangalore");
		assertEquals(flight.getTo_city(), "Delhi");
		assertEquals(flight.getDate_of_departure(), "09-03-2021");
	}

	interface Flight {

		String getFrom_city();

		String getTo_city();

		String getDate_of_departure();

		void setFrom_city(String from_city);

		void setTo_city(String to_city);

		void setDate_of_departure(String date_of_departure);
	}

}
