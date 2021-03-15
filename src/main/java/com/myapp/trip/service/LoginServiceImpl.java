package com.myapp.trip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.trip.model.Login;
import com.myapp.trip.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	LoginRepository logindao;

	@Override
	public Login authentication(String username, String password) {
		return logindao.authentication(username, password);
	}

}
