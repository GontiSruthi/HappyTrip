package com.myapp.trip.tdd.web;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.myapp.trip.model.Booking;
import com.myapp.trip.model.Common.PreferredClass;
import com.myapp.trip.model.FlightDetails;
import com.myapp.trip.model.Passenger;
import com.myapp.trip.service.BookingService;
import com.myapp.trip.service.FareService;
import com.myapp.trip.service.FlightDetailsService;
import com.myapp.trip.service.PassengerService;

//@SpringBootTest
@WebMvcTest
public class BookingControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private BookingService service;
	@MockBean
	private FlightDetailsService flightservice;
	@MockBean
	private PassengerService passengerservice;
	@MockBean
	private FareService fareservice;

	@BeforeEach
	public void setup() {

	}

	@Test
	public void testgetTicket() throws Exception {
		int id = 1;

		when(service.getBookingById(id)).thenReturn(getBookInfo());

		MvcResult result = mockMvc.perform(get("/getTicket").param("id", "1")).andExpect(status().isOk()).andReturn();
		System.out.println(result.getResponse().getContentAsString());
		assertTrue(result.getResponse().getContentAsString()
				.contains("<h1>Welcome to HappyTrip </h1> "
						+ "<h2>Your booking has been confirmed. Kindly refer the details: </h2>"
						+ "<strong>Booking ID: </strong>" + getBookInfo().getId() + "<br><strong>Name: </strong>"
						+ getBookInfo().getPassenger().getName() + "<br><strong>Age: </strong> "
						+ getBookInfo().getPassenger().getAge() + "<br><strong>Gender: </strong>"
						+ getBookInfo().getPassenger().getGender() + "<br><strong>Source: </strong>"
						+ getBookInfo().getFlight().getFrom_city() + "<br><strong>Destination: </strong>"
						+ getBookInfo().getFlight().getTo_city() + "<br><strong>Preferred Class: </strong> "
						+ getBookInfo().getPreferredClass() + "<br><strong>Fare: </strong>" + getBookInfo().getFare()));
		System.out.println(result.getResponse().getContentAsString());
		assertFalse(result.getResponse().getContentAsString()
				.contains("<h1>Welcome to HappyTrip </h1> <h2>No booking found with the id:" + id + " </h2>"));

	}

	private Booking getBookInfo() {
		FlightDetails flight = new FlightDetails(1, "Banglore", "Pune", "2021-02-24", 4353, "IndiaGo", "01:00:00",
				"12:35:04", 30, 30);
		Booking booking = new Booking();
		Passenger passenger = new Passenger(1, "sruthi", "female", 21, 98765432);
		booking.setId(1);
		booking.setPassenger(passenger);
		booking.setFlight(flight);
		booking.setPreferredClass(PreferredClass.BusinessClass);
		booking.setFare(5600);

		return booking;
	}

}
