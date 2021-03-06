package com.myapp.trip.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myapp.trip.model.Login;

@Transactional
@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
	@Query("select login from Login login  where username=?1 and pass=?2 ")
	public Login authentication(String username, String pass);
}
