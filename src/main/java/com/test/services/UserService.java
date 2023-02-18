package com.test.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entities.User;
import com.test.repository.UserRepository;
@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	//get all users
	public List<User> getAllUser(){
		List<User> user= new ArrayList<User>();
		userRepository.findAll().forEach(user1->user.add(user1));
		return user;	
	}
	
	//find specific user by id 
	public User getUserById(int id) {
		return userRepository.findById(id).get();
		
	}
	
	//save user
	public void save(User user) {
		userRepository.save(user);
	}
	
	//Delete specific user by id 
	public void delete(int id) {
		userRepository.deleteById(id);
	}
	
	//update user
	public void update(User user) {
		userRepository.save(user);
	}

	public void saveAll(List<User> user) {
		userRepository.saveAll(user);
		
	}

	
	}
	