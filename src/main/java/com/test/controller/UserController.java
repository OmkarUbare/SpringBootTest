package com.test.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.test.entities.User;
import com.test.services.UserService;

@RestController
public class UserController {
	
	@Autowired
   UserService userService;
	
	@PostMapping("/userSave")
	public User saveUser(@RequestBody User user) {
		userService.save(user);
		return user;
	}
	@PostMapping("/userSaveAll")
	public List<User> saveAllUser(@RequestBody List<User> user) {
		userService.saveAll(user);
		return user;
	}
		
	@GetMapping("user/{userId}")
	private User getUser(@PathVariable("userId")int userId) {
		return userService.getUserById(userId);
	}
	

	@GetMapping("/getAllUser")
	private ResponseEntity<List<User>> getAlluser() {
		List<User>list=userService.getAllUser();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}	
	
	@PutMapping("/user")
	private User updateUser(@RequestBody User user) {
	    userService.update(user);
		return user;
	}
	
	@DeleteMapping("/user/{userId}")
	private void deleteUserById(@PathVariable("userId")int userId) {
		userService.delete(userId);
	}
}
