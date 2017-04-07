package com.cts.springjdbc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.springjdbc.model.User;
import com.cts.springjdbc.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User getUser(@PathVariable("id") int id){
		return userService.getUser(id);
	}
	
	@RequestMapping(value="/getlist", method=RequestMethod.GET)
	public @ResponseBody List<User> getListUser(){
		return userService.getAllUsers();
	}
}
