package com.myapp.trip.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.myapp.trip.dto.BookingDto;
//import com.myapp.trip.model.Passenger;

public class BookingDtoTest {
	@Test
	public void getDtoInfo() {
		BookingDto bookingdto = new BookingDto();
		bookingdto.setPassenger(null);
		// passenger.setGender("female");
		bookingdto.setSource("hyderabad");
		bookingdto.setDestination("vizag");
		bookingdto.setDate("11-09-2021");
		bookingdto.setPreferredClass(null);

		assertEquals(null, bookingdto.getPassenger());
		assertEquals("hyderabad", bookingdto.getSource());
		assertEquals("vizag", bookingdto.getDestination());
		assertEquals("11-09-2021", bookingdto.getDate());
		assertEquals(null, bookingdto.getPreferredClass());
	}
}
