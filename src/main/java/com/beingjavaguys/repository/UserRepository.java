package com.beingjavaguys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.beingjavaguys.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("select mu from MoodleUser mu")
	public List<User> findAllMoodleUsers();
}
