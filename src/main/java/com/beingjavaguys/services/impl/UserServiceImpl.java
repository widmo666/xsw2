package com.beingjavaguys.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.beingjavaguys.model.User;
import com.beingjavaguys.repository.UserRepository;
import com.beingjavaguys.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@PersistenceContext
	private EntityManager em;

	// @Autowired
	public UserRepository userRepository;

	@Override
	public List<User> getAllMoodleUsers() {
		Query createQuery = em.createQuery("select m from User m");
		List<User> resultList = createQuery.getResultList();
		return resultList;
		// return moodleUserRepository.findAllMoodleUsers();
		// return null;
	}

}
