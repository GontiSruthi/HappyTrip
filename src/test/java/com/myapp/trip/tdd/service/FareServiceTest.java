package com.myapp.trip.tdd.service;

import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.myapp.trip.MyTripApplication;
import com.myapp.trip.model.Fare;
import com.myapp.trip.repository.FareRepository;
import com.myapp.trip.service.FareServiceImpl;

@SpringBootTest(classes = MyTripApplication.class)
@RunWith(MockitoJUnitRunner.class)
public class FareServiceTest {
	@InjectMocks
	private FareServiceImpl service;

	@Mock
	private FareRepository repository;

	@SuppressWarnings("deprecation")
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@DisplayName("Test for FareService")
	public void testFareService() {
		when(service.getFareByFlightId(1)).thenReturn(getMockFare());
		Fare fs = service.getFareByFlightId(1);
		assertNotEquals(getMockFare(), fs);
	}

	private Fare getMockFare() {
		Fare mocklogin = new Fare();
		mocklogin.setBusinessClassFare(1500);
		mocklogin.setEconomyClassFare(2000);
		return mocklogin;
	}
}
