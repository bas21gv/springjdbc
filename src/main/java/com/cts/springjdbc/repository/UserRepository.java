package com.cts.springjdbc.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cts.springjdbc.model.User;

public interface UserRepository {
	
	public User getById(int id);
	public List<User> getAll();
}
