package com.myapp.trip.tdd.web;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.myapp.trip.model.Login;
import com.myapp.trip.service.LoginService;
import com.myapp.trip.web.LoginController;

@ExtendWith(MockitoExtension.class)
public class LoginControllerTest {

	@InjectMocks
	private LoginController loginController;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	Login login;

	@Mock
	LoginService loginService;

	private String username = "sruthi";
	private String password = "123";

	@BeforeEach
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
	}

	@Test
	public void testAuthentication() throws Exception {

		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/userlogin/")
				.param("username", username).param("password", password);
		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
		System.out.println(result.getResponse().getContentAsString());
		assertTrue(result.getResponse().getContentAsString().contains("<style>h3 {color:red;}</style>"
				+ "<center><h3>Invalid Details! Please enter valid username and password</h3></center>"));
		assertFalse(result.getResponse().getContentAsString()
				.contains("<style>h1 {color:green;}</style>" + "<center><h1>Login Success!!!</h1></center>"));

	}

}
