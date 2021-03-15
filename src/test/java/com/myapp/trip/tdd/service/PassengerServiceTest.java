package com.myapp.trip.tdd.service;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doReturn;

//import java.util.Arrays;
//import java.util.Collection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.myapp.trip.model.Passenger;
//import com.myapp.trip.model.User;
import com.myapp.trip.repository.PassengerRepository;
//import com.myapp.trip.repository.UserRepository;
import com.myapp.trip.service.PassengerService;

//import com.myapp.trip.service.UserService;
@SpringBootTest
public class PassengerServiceTest {
	@Autowired
	private PassengerService service;
	@MockBean
	private PassengerRepository repository;

	@Test
	@DisplayName("Test PassengerImpl")
	public void testPassengerServiceImpl() {
		Passenger mockpassenger = new Passenger();
		mockpassenger.setName("saloni");
		mockpassenger.setId(1);
		String name = "saloni";
		int id = 1;
		doReturn(mockpassenger).when(repository).findTopByName(name);
		doReturn(mockpassenger).when(repository).findById(id);
		Passenger foundpassenger = service.getPassengerByName("saloni");
		Passenger foundpassenger1 = service.getPassengerById(1);
		assertNotNull(foundpassenger);
		assertNotNull(foundpassenger1);
		assertSame("saloni", foundpassenger.getName());
		assertSame(1, foundpassenger1.getId());
	}

}