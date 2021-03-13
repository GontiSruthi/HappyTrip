package com.myapp.trip.tdd.web;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.myapp.trip.model.Flight;
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
	public void setup() throws JsonParseException, JsonMappingException, IOException {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	@DisplayName("get request for flight using GET /SearchFlight ")
	public void testFindAllFlights() throws Exception {

		Flight mockFlight = new Flight();
		mockFlight.setFrom_city("Bangalore");
		mockFlight.setTo_city("Delhi");
		mockFlight.setDate_of_departure("09-03-2021");

		doReturn(mockFlight).when(service).findFlights(mockFlight.getFrom_city(), mockFlight.getTo_city(),
				mockFlight.getDate_of_departure());

		MvcResult mvcResult = mockMvc
				.perform(get("/SearchFlight/{from_city}/{to_city}/{date_of_departure}", "Bangalore", "Delhi",
						"09-03-2021"))
				.andExpect(status().isOk()).andExpect(content().contentType("application/json")).andReturn();

		Assert.assertEquals("application/json", mvcResult.getResponse().getContentType());
	}
}