package com.myapp.trip.tdd.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.myapp.trip.service.FlightServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FlightControllerTest {

	@MockBean
	private FlightServiceImpl service;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	@DisplayName("get request for flight using GET /SearchFlight ")
	public void testFindAllFlights() throws Exception {
		mockMvc.perform(
				get("/SearchFlight/{from_city}/{to_city}/{date_of_departure}", "Bangalore", "Delhi", "09-03-2021"))
				.andExpect(status().isOk());
	}
}