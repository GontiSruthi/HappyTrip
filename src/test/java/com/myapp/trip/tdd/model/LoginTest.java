package com.myapp.trip.tdd.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.myapp.trip.model.Login;

//@RunWith(SpringRunner.class)
@SpringBootTest // (classes = HappyTripApplication.class)
public class LoginTest {
	@Autowired
	Login login;

	@Test
	public void testLogin() {
		Login login = new Login(1, "sruthi", "123");
		login.setId(1);
		login.setUsername("sruthi");
		login.setPassword("123");
		assertEquals(1, login.getId());
		assertEquals("sruthi", login.getUsername());
		assertEquals("123", login.getPassword());
	}
}