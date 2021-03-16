package com.myapp.trip.tdd.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.myapp.trip.model.Login;

public class LoginTest {
	public Login login;

	@BeforeEach
	void setUp() {
		login = new Login(1, "sruthi", "123");
	}

	@AfterEach
	void tearDown() {
		login = null;
	}

	@Test
	public void testLogin() {
		assertEquals(1, login.getId());
		assertEquals("sruthi", login.getUsername());
		assertEquals("123", login.getPass());
	}
}