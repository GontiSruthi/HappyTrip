package com.myapp.trip.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.myapp.trip.model.Booking;
import com.myapp.trip.model.Common.PreferredClass;
import com.myapp.trip.model.Fare;
import com.myapp.trip.model.FlightDetails;
import com.myapp.trip.model.Passenger;
import com.myapp.trip.repository.BookingRepository;
import com.myapp.trip.service.BookingService;

@SpringBootTest
public class BookingServiceTest {
	@Autowired
	BookingService service;
	@MockBean
	BookingRepository bookingrepo;

	@Test
	@DisplayName("Test for BookingService")
	public void testBookService() {

		Booking mockbook = new Booking();
		mockbook.setId(1);
		int id = 1;
		doReturn(mockbook).when(bookingrepo).findById(id);
		Booking foundBooking = service.getBookingById(id);
		assertNotNull(foundBooking);
		assertEquals(id, foundBooking.getId());

	}

	@Test
	@DisplayName("Test Flight For booking confirm")
	public void testFlightForBookingConfirm() {
		Booking book = new Booking();
		Booking book1 = new Booking();
		Passenger passenger = new Passenger();
		FlightDetails flight = new FlightDetails(1, "Banglore", "Pune", "2021-02-24", 4353, "IndiaGo", "01:00:00",
				"12:35:04", 30, 30);
		passenger.setId(1);
		passenger.setGender("female");
		passenger.setName("saloni");
		passenger.setAge(21);
		passenger.setContact(98765432);
		Fare fare = new Fare();
		fare.setId(1);
		fare.setBusinessClassFare(5000);
		fare.setEconomyClassFare(8000);
		fare.setFlight(flight);
		book.setBookedDate("2021-03-11");
		book.setOnBoardingDate("2021-03-21");
		book.setPreferredClass(PreferredClass.BusinessClass);
		book1.setPreferredClass(PreferredClass.EconomyClass);

		Booking booked = service.save(new Booking(passenger, flight, book.getBookedDate(), fare.getBusinessClassFare(),
				book.getPreferredClass()));

		Booking booked1 = service.save(new Booking(passenger, flight, book.getBookedDate(), fare.getBusinessClassFare(),
				book1.getPreferredClass()));

		assertEquals(booked,
				service.confirmBooking(passenger, flight, book.getBookedDate(), book.getPreferredClass(), fare));
		assertEquals(booked1,
				service.confirmBooking(passenger, flight, book.getBookedDate(), book1.getPreferredClass(), fare));

		assertEquals(flight.getId(), passenger.getId());

	}
}
