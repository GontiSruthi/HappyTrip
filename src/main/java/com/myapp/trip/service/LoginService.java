package com.myapp.trip.service;

import com.myapp.trip.model.Login;

public interface LoginService {

	Login authentication(String uname, String pass);

}
