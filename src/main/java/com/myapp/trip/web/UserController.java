package com.myapp.trip.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.trip.model.User;
import com.myapp.trip.service.UserService;

@RestController
@RequestMapping("/register")
public class UserController {
	@Autowired
	UserService userservice;

	@GetMapping("/{id}")
	public String getById(@PathVariable("id") int id) {
		User userobj = userservice.getById(id);
		if (userobj != null) {
			return "<style>h1 {color: blue;}marquee {color: green;}h2 {color: Magenta}</style><center><h1>WELCOME TO HAPPY TRIP</h1> "
					+ "<marquee><i>Your Registration is Sucessfull!!!</i></marquee>" + "<h2>PROFILE</h2>"
					+ "<strong>User ID: </strong>" + userobj.getId() + "<br><strong>Name: </strong>" + userobj.getName()
					+ "<br><strong>Age: </strong> " + userobj.getAge() + "<br><strong>Gender: </strong>"
					+ userobj.getGender() + "<br><strong>Address: </strong>" + userobj.getAddress()
					+ "<br><strong>Country:</strong>" + userobj.getCountry() + "<br><strong>Email-Id : </strong>"
					+ userobj.getEmailid() + "<br><strong>Contact : </strong>" + userobj.getContact() + "</center>";
		} else {
			return "<html><body><style>h1 {color:red;}</style>"
					+ "<center><h1>Your not a Registered User </h1></center>" + "</body></html>";
		}
	}
}