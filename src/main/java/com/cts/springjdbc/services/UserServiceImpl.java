package com.cts.springjdbc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.springjdbc.model.User;
import com.cts.springjdbc.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User getUser(int id) {
		return userRepository.getById(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.getAll();
	}

}
