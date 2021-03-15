package com.myapp.trip.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.myapp.trip.model.Common.PreferredClass;
import com.myapp.trip.model.FlightDetails;
import com.myapp.trip.repository.FlightDetailsRepository;
import com.myapp.trip.service.FlightDetailsService;

@SpringBootTest
public class FlightDetailsServiceTest {
	@Autowired
	private FlightDetailsService service;

	@MockBean
	private FlightDetailsRepository repository;

	@Test
	@DisplayName("Test Flight with Flight Id successfully")
	public void testFlightWithFlightId() {
		FlightDetails mockFlightDetails = new FlightDetails();
		mockFlightDetails.setFlight_id(1);

		doReturn(mockFlightDetails).when(repository).getFlightById(1);

		assertSame(1, mockFlightDetails.getFlight_id());
	}

	@Test
	@DisplayName("Test Flight with Flight_no successfully")
	public void testFlightNotFoundForNonExistingId() {
		FlightDetails mockFlight = new FlightDetails();
		// Integer flight_id = new Integer(2121);

		mockFlight.setFlight_id(2121);
		doReturn(mockFlight).when(repository).findFlightById(2121);
		FlightDetails foundFlight = service.findFlightById(2121);
		assertNotNull(foundFlight);

		assertEquals(2121, foundFlight.getFlight_id());
	}

	@Test
	@DisplayName("Fail to Find flight with id ")
	public void testFailToFindFlightById() {

		doReturn(null).when(repository).findFlightById(2121);

		FlightDetails foundFlight = service.findFlightById(2121);
		assertNull(foundFlight);

	}

	@Test
	@DisplayName("Test Flight with Source, Destination and date of travel successfully")
	public void testFlightWithSourceDestinationDate() {
		FlightDetails mockFlightDetails = new FlightDetails();
		mockFlightDetails.setFrom_city("Bangalore");
		mockFlightDetails.setTo_city("Delhi");
		mockFlightDetails.setTravel_date("09-03-2021");

		doReturn(mockFlightDetails).when(repository).findBySourceAndDestinationAndDate("Bangalore", "Delhi",
				"09-03-2021");

		FlightDetails foundFlight = service.searchFlight("Bangalore", "Delhi", "09-03-2021");
		assertNotNull(foundFlight);
		assertSame("Bangalore", foundFlight.getFrom_city());
		assertSame("Delhi", foundFlight.getTo_city());
		assertSame("09-03-2021", foundFlight.getTravel_date());
	}

	@Test
	@DisplayName("Test Flight For Checking Seat Availability successfully")
	public void testFlightForCheckSeatAvailability() {
		FlightDetails mockFlightDetails = new FlightDetails();
		mockFlightDetails.setAvailable_business_seats(10);

		assertFalse(service.checkSeatAvailability(mockFlightDetails, PreferredClass.BusinessClass));
	}

}