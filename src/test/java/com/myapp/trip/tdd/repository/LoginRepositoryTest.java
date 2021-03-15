package com.myapp.trip.tdd.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

@SpringBootTest
public class LoginRepositoryTest {
	ProjectionFactory factory = new SpelAwareProxyProjectionFactory();

	@Test
	public void createMapBackedProjection() {
		Login login = factory.createProjection(Login.class);
		login.setUsername("sruthi");
		login.setPassword("123");
		assertEquals(login.getUsername(), "sruthi");
		assertEquals(login.getPassword(), "123");
	}

	@Test
	public void createsProxyForSourceMap() {
		Map<String, Object> backingMap = new HashMap<>();
		backingMap.put("username", "sruthi");
		backingMap.put("password", "123");
		Login login = factory.createProjection(Login.class, backingMap);
		assertEquals(login.getUsername(), "sruthi");
		assertEquals(login.getPassword(), "123");
	}

	interface Login {
		String getUsername();

		String getPassword();

		void setUsername(String username);

		void setPassword(String password);
	}
}
