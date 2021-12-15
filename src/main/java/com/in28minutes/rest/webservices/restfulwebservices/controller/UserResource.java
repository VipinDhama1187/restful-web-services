package com.in28minutes.rest.webservices.restfulwebservices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.webservices.restfulwebservices.dto.BaseResponse;
import com.in28minutes.rest.webservices.restfulwebservices.dto.User;
import com.in28minutes.rest.webservices.restfulwebservices.service.UserService;

@RestController
public class UserResource {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public ResponseEntity<BaseResponse<List<User>>> getUsers() {
		return new ResponseEntity<BaseResponse<List<User>>>(
				new BaseResponse<List<User>>("Success", HttpStatus.OK.value(), userService.findAll()), HttpStatus.OK);
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<BaseResponse<User>> getUser(@PathVariable int id) {
		return new ResponseEntity<BaseResponse<User>>(new BaseResponse<User>("Success", HttpStatus.OK.value(), userService.findOne(id)),
				HttpStatus.OK);
	}
	
	@SuppressWarnings("static-access")
	@PostMapping("/users")
	public ResponseEntity<BaseResponse<User>> createUser(@RequestBody User user) {
		User savedUser = userService.createUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return new ResponseEntity<BaseResponse<User>>(new BaseResponse<User>("Success", HttpStatus.CREATED.value(), savedUser),
				HttpStatus.CREATED).created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<BaseResponse<User>> deleteUser(@PathVariable int id) {
		return new ResponseEntity<BaseResponse<User>>(new BaseResponse<User>("Success", HttpStatus.OK.value(), userService.deleteUser(id)),
				HttpStatus.OK);
	}
	
	
}
