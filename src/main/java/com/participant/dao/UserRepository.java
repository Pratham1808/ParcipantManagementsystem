package com.participant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.participant.entity.Signup;

public interface UserRepository extends JpaRepository<Signup, Integer>{
	
	@Query("select u from Signup u where u.email=:email")
	public Signup getUserByUserName(@Param("email") String email);
}
