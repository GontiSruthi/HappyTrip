package com.myapp.trip.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.myapp.trip.model.Flight;
import com.myapp.trip.repository.FlightRepository;
import com.myapp.trip.service.FlightService;

@SpringBootTest
public class FlightServiceTest {

	@Autowired
	private FlightService service;

	@MockBean
	private FlightRepository repository;

	@Test
	@DisplayName("Test Flight with Source, Destination and date of travel successfully")
	public void testFlightNotFoundForNonExistingId() {
		Flight mockFlight = new Flight();
		mockFlight.setFrom_city("Bangalore");
		mockFlight.setTo_city("Delhi");
		mockFlight.setDate_of_departure("09-03-2021");

		doReturn(mockFlight).when(repository).findFlights("Bangalore", "Delhi", "09-03-2021");

		Flight foundFlight = service.findFlights("Bangalore", "Delhi", "09-03-2021");
		assertNotNull(foundFlight);
		assertSame("Bangalore", foundFlight.getFrom_city());
		assertSame("Delhi", foundFlight.getTo_city());
		assertSame("09-03-2021", foundFlight.getDate_of_departure());
	}

	@Test
	@DisplayName("Fail to Find flight with Source, Destination and date of travel")
	public void testFailToFindFlightById() {
		doReturn(null).when(repository).findFlights("Bangalore", "Delhi", "09-03-2021");

		Flight foundFlight = service.findFlights("Bangalore", "Delhi", "09-03-2021");
		assertNull(foundFlight);
	}

	@Test
	@DisplayName("Find All Flights ")
	public void testFindAllFlights() {
		Flight mockFlight1 = new Flight();
		mockFlight1.setFrom_city("Bangalore");
		mockFlight1.setTo_city("Delhi");
		mockFlight1.setDate_of_departure("09-03-2021");

		Flight mockFlight2 = new Flight();
		mockFlight2.setFrom_city("Jaipur");
		mockFlight2.setTo_city("Mumbai");
		mockFlight2.setDate_of_departure("10-03-2021");

		doReturn(Arrays.asList(mockFlight1, mockFlight2)).when(repository).findAll();

		Iterable<Flight> flights = service.findAll();
		assertEquals(2, ((Collection<?>) flights).size());
	}
}
