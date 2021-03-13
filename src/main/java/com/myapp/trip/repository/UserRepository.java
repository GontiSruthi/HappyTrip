package com.myapp.trip.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.myapp.trip.model.User;

@Transactional
@RestResource(path = "users")
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("select users from User users  where id=?1 ")
	public User getById(int id);
}