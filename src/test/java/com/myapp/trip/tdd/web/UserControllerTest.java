package com.myapp.trip.tdd.web;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.myapp.trip.model.User;
import com.myapp.trip.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private UserService userService;

	@BeforeEach
	public void setup() {

	}

	@Test
	public void testCreateUser() throws Exception {
		int id = 1;
		when(userService.getById(id)).thenReturn(getUserInfo());

		MvcResult result = mockMvc.perform(get("/register/1")).andExpect(status().isOk()).andReturn();
		System.out.println(result.getResponse().getContentAsString());
		assertTrue(result.getResponse().getContentAsString().contains(
				"<style>h1 {color: blue;}marquee {color: green;}h2 {color: Magenta}</style><center><h1>WELCOME TO HAPPY TRIP</h1> "
						+ "<marquee><i>Your Registration is Sucessfull!!!</i></marquee>" + "<h2>PROFILE</h2>"
						+ "<strong>User ID: </strong>" + getUserInfo().getId() + "<br><strong>Name: </strong>"
						+ getUserInfo().getName() + "<br><strong>Age: </strong> " + getUserInfo().getAge()
						+ "<br><strong>Gender: </strong>" + getUserInfo().getGender() + "<br><strong>Address: </strong>"
						+ getUserInfo().getAddress() + "<br><strong>Country:</strong>" + getUserInfo().getCountry()
						+ "<br><strong>Email-Id : </strong>" + getUserInfo().getEmailid()
						+ "<br><strong>Contact : </strong>" + getUserInfo().getContact() + "</center>"));
		System.out.println(result.getResponse().getContentAsString());
		assertFalse(result.getResponse().getContentAsString().contains("<html><body><style>h1 {color:red;}</style>"
				+ "<center><h1>Your not a Registered User </h1></center>" + "</body></html>"));

	}

	private User getUserInfo() {
		User user = new User();
		user.setId(1);
		user.setGender("female");
		user.setEmailid("saloni@gmail.com");
		user.setName("saloni");
		user.setAge(21);
		user.setAddress("Rajasthan");
		user.setCountry("India");
		user.setContact(98765432);

		return user;

	}
}