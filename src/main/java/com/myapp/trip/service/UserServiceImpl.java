package com.myapp.trip.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.trip.model.User;
import com.myapp.trip.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	@Autowired	
	UserRepository  bcgdao;
	
	@Override
	public User getById(int id) {
		
		return bcgdao.getById(id);
	}

}
