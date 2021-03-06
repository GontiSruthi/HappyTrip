package com.myapp.trip.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.trip.model.Login;
import com.myapp.trip.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	LoginService loginservice;

	@GetMapping("/userlogin")
	public String authentication(@RequestParam("username") String uname, @RequestParam("password") String pass) {
		Login loginobj = loginservice.authentication(uname, pass);
		if (loginobj != null) {

			return "<style>h1 {color:green;}</style>" + "<center><h1>Login Success!!!</h1></center>";

		} else {
			return "<style>h3 {color:red;}</style>"
					+ "<center><h3>Invalid Details! Please enter valid username and password</h3></center>";
		}

	}

}
