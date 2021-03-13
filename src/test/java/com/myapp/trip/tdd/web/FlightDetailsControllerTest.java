package com.myapp.trip.tdd.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.myapp.trip.model.FlightDetails;
import com.myapp.trip.service.FlightDetailsServiceImpl;

//@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FlightDetailsControllerTest {

	@MockBean
	private FlightDetailsServiceImpl service;
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext webApplicationContext;
	// @Autowired
	// private ObjectMapper mapper;

	@BeforeEach
	public void setup() throws JsonParseException, JsonMappingException, IOException {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	@DisplayName("get request for flight using GET /SearchFlight ")
	public void testFindAllFlights() throws Exception {
		FlightDetails mockFlight = new FlightDetails();

		mockFlight.setFlight_id(2121);

		doReturn(mockFlight).when(service).findFlightById(mockFlight.getFlight_id());
		MvcResult mvcResult = mockMvc.perform(get("/flight/{flightId}", 2121)).andExpect(status().isOk())
				.andExpect(content().contentType("application/json")).andReturn();
		assertEquals("application/json", mvcResult.getResponse().getContentType());

	}

}
