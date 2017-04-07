package com.cts.springjdbc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.springjdbc.model.User;

public interface UserService {
	
	public User getUser(int id);
	public List<User> getAllUsers();
}
