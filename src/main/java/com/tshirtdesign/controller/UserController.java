/**
 * 
 */
package com.tshirtdesign.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tshirtdesign.model.User;
import com.tshirtdesign.service.UserService;

/**
 * @author saroj-gautam
 *
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

	@GetMapping(value = "/message")
	public String getMessage() {
		return "Got Message";
	}

	@Autowired
	private UserService userService;

	// Register a new user
	@PostMapping(value = "/register")
	public ResponseEntity<Void> addUser() {
		User user = new User();
		user.setFirstName("Saroj");
		user.setLastName("Gautam");
		user.setEmail("sarojnp2003+1@gmail.com");
		user.setPassword("test123");
		user.setAddress("nepal");
		user.setTelephone("1234567890");
		user.setRole("ROLE_ADMIN");

		userService.saveUser(user);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	// Get all users
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> user = userService.findAllUser();
		return new ResponseEntity<List<User>>(user, HttpStatus.OK);
	}
}