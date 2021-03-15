package com.myapp.trip.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.trip.dto.BookingDto;
import com.myapp.trip.model.Booking;
import com.myapp.trip.model.Common.PreferredClass;
import com.myapp.trip.model.Fare;
import com.myapp.trip.model.FlightDetails;
import com.myapp.trip.model.Passenger;
import com.myapp.trip.service.BookingService;
import com.myapp.trip.service.FareService;
import com.myapp.trip.service.FlightDetailsService;
import com.myapp.trip.service.PassengerService;
import com.sun.el.parser.ParseException;

@RestController
public class BookingController {
	@Autowired
	FlightDetailsService flightService;

	@Autowired
	PassengerService passengerService;

	@Autowired
	FareService fareService;

	@Autowired
	BookingService bookingService;

	@PostMapping("/bookTicket")
	public Map<String, Object> bookTicket(@RequestBody BookingDto bookingDto) throws ParseException {
		Map<String, Object> map = new HashMap<>();

		Passenger passenger = bookingDto.getPassenger();
		String source = bookingDto.getSource();
		String destination = bookingDto.getDestination();
		String date = bookingDto.getDate();
		PreferredClass preferredClass = bookingDto.getPreferredClass();

		FlightDetails flight = flightService.searchFlight(source, destination, date);
		if (flight == null) {
			map.put("�rror", "No flight found for the selected cities");
			return map;
		}

		Boolean isSeatAvailable = flightService.checkSeatAvailability(flight, preferredClass);
		if (!isSeatAvailable) {
			map.put("Sorry!", "No " + preferredClass + " seats available");
			return map;
		}

		Fare fare = fareService.getFareByFlightId(flight.getId());
		Booking booking = bookingService.confirmBooking(passenger, flight, date, preferredClass, fare);

		map.put("Booking id", booking.getId());
		map.put("Name", passenger.getName());
		map.put("Age", passenger.getAge());
		map.put("Gender", passenger.getGender());
		map.put("source", source);
		map.put("destination", destination);
		map.put("Preferred Class", preferredClass);
		map.put("fare", booking.getFare());

		return map;
	}

	@GetMapping("/getTicket")
	public String getTicket(@RequestParam("id") int id) {
		Booking booking = bookingService.getBookingById(id);
		if (booking == null)
			return "<h1>Welcome to HappyTrip </h1> <h2>No booking found with the id:" + id + " </h2>";
		return "<h1>Welcome to HappyTrip </h1> "
				+ "<h2>Your booking has been confirmed. Kindly refer the details: </h2>"
				+ "<strong>Booking ID: </strong>" + booking.getId() + "<br><strong>Name: </strong>"
				+ booking.getPassenger().getName() + "<br><strong>Age: </strong> " + booking.getPassenger().getAge()
				+ "<br><strong>Gender: </strong>" + booking.getPassenger().getGender() + "<br><strong>Source: </strong>"
				+ booking.getFlight().getFrom_city() + "<br><strong>Destination: </strong>"
				+ booking.getFlight().getTo_city() + "<br><strong>Preferred Class: </strong> "
				+ booking.getPreferredClass() + "<br><strong>Fare: </strong>" + booking.getFare();
	}

//	@GetMapping("/all-bookings")
//	public List<Booking> getAllBookings() {
//		return bookingService.getBookings();
//	}

}
