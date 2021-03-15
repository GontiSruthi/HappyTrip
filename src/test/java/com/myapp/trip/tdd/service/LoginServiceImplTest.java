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

import com.myapp.trip.HappyTripApplication;
import com.myapp.trip.model.Login;
import com.myapp.trip.repository.LoginRepository;
import com.myapp.trip.service.LoginServiceImpl;

@SpringBootTest(classes = HappyTripApplication.class)
@RunWith(MockitoJUnitRunner.class)
public class LoginServiceImplTest {
	@InjectMocks
	private LoginServiceImpl service;

	@Mock
	private LoginRepository repository;

	@SuppressWarnings("deprecation")
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@DisplayName("Test for authentication")
	public void testLoginAuthentication() {
		when(service.authentication("sruthi", "123")).thenReturn(getMockLogin());
		Login authenticated = service.authentication("sruthi", "123");
		assertNotEquals(getMockLogin(), authenticated);

//		doReturn(mocklogin).when(service.authentication("sruthi", "123"));
//
//		Login authenticated = service.authentication("sruthi", "123");
//		assertNotNull(authenticated);

	}

	private Login getMockLogin() {
		Login mocklogin = new Login();
		mocklogin.setUsername("sruthi");
		mocklogin.setPassword("123");
		return mocklogin;
	}
}
