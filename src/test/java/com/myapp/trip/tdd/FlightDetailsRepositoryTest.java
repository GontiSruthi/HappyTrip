package com.myapp.trip.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

@SpringBootTest
public class FlightDetailsRepositoryTest {

	ProjectionFactory factory = new SpelAwareProxyProjectionFactory();

	@Test
	public void createMapBackedProjection() {

		FlightDetails flightDetails = factory.createProjection(FlightDetails.class);

		flightDetails.setFlight_id(1);
		flightDetails.setFrom_city("Bangalore");
		flightDetails.setTo_city("Delhi");
		flightDetails.setTravel_date("09-03-2021");
		flightDetails.setAvailable_business_seats(10);

		assertEquals(flightDetails.getFlight_id(), 1);
		assertEquals(flightDetails.getFrom_city(), "Bangalore");
		assertEquals(flightDetails.getTo_city(), "Delhi");
		assertEquals(flightDetails.getTravel_date(), "09-03-2021");
		assertEquals(flightDetails.getAvailable_business_seats(), 10);
	}

	@Test
	public void createsProxyForSourceMap() {

		Map<String, Object> backingMap = new HashMap<>();

		backingMap.put("flight_id", 1);
		backingMap.put("from_city", "Bangalore");
		backingMap.put("to_city", "Delhi");
		backingMap.put("travel_date", "09-03-2021");
		backingMap.put("available_business_seats", 10);

		FlightDetails flightDetails = factory.createProjection(FlightDetails.class, backingMap);

		assertEquals(flightDetails.getFlight_id(), 1);
		assertEquals(flightDetails.getFrom_city(), "Bangalore");
		assertEquals(flightDetails.getTo_city(), "Delhi");
		assertEquals(flightDetails.getTravel_date(), "09-03-2021");
		assertEquals(flightDetails.getAvailable_business_seats(), 10);
	}

	interface FlightDetails {
		int getFlight_id();

		String getFrom_city();

		String getTo_city();

		String getTravel_date();

		int getAvailable_business_seats();

		void setFlight_id(int Flight_id);

		void setFrom_city(String from_city);

		void setTo_city(String to_city);

		void setTravel_date(String travel_date);

		void setAvailable_business_seats(int available_business_seats);
	}
}
