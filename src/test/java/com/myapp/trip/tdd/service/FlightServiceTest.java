package com.myapp.trip.tdd.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doReturn;

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
}
