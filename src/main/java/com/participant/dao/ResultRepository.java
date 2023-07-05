package com.participant.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.participant.entity.Participant;


public interface ResultRepository extends JpaRepository<Participant, Integer>{
	@Query("select u from Participant u where u.email=:email")
	public Participant getUserByUserName(@Param("email") String email);
}
