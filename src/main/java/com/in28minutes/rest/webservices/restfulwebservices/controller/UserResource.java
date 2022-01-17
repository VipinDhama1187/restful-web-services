package com.in28minutes.rest.webservices.restfulwebservices.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.restfulwebservices.dto.BaseResponse;
import com.in28minutes.rest.webservices.restfulwebservices.entity.MyUserDetails;
import com.in28minutes.rest.webservices.restfulwebservices.entity.User;
import com.in28minutes.rest.webservices.restfulwebservices.user.service.UserService;

/**
 * The Class UserResource.
 */
@RestController
public class UserResource {

	/** The user service. */
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDetailsManager userDetailsServiceImpl;

	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	@GetMapping("/users")
	public ResponseEntity<BaseResponse<List<User>>> getUsers() {
		return new ResponseEntity<BaseResponse<List<User>>>(
				new BaseResponse<List<User>>("Success", HttpStatus.OK.value(), userService.findAll()), HttpStatus.OK);
	}

	/**
	 * Gets the user.
	 *
	 * @param id the id
	 * @return the user
	 */
	@GetMapping("/users/{id}")
	public ResponseEntity<BaseResponse<User>> getUser(@PathVariable int id) {
		//EntityModel<BaseResponse<User>> entityModal = EntityModel.of(new BaseResponse<User>("Success", HttpStatus.OK.value(), userService.findOne(id)));
		
		//WebMvcLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).getUsers());
		//entityModal.add(linkBuilder.withRel("all-users"));
		return new ResponseEntity<BaseResponse<User>>(new BaseResponse<User>("Success", HttpStatus.OK.value(), userService.findOne(id)),
				HttpStatus.OK);
	}
	
	/**
	 * Creates the user.
	 *
	 * @param user the user
	 * @return the response entity
	 */
	@PostMapping("/user")
	public ResponseEntity<BaseResponse<String>> createUser(@Valid @RequestBody User user) {
		MyUserDetails myUserDetails = new MyUserDetails(user);
		 userDetailsServiceImpl.createUser(myUserDetails);
	//	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return new ResponseEntity<BaseResponse<String>>(new BaseResponse<String>("Success", HttpStatus.CREATED.value(), String.format("User with username %s successfully created", user.getUsername())),
				HttpStatus.CREATED);
	}
	
	@PutMapping("/user")
	public ResponseEntity<BaseResponse<String>> updateUser(@Valid @RequestBody User user) {
		MyUserDetails myUserDetails = new MyUserDetails(user);
		 userDetailsServiceImpl.updateUser(myUserDetails);
	//	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return new ResponseEntity<BaseResponse<String>>(new BaseResponse<String>("Success", HttpStatus.OK.value(), String.format("User with username %s successfully created", user.getUsername())),
				HttpStatus.OK);
	}
	
	/**
	 * Delete user.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping("/users/{id}")
	public ResponseEntity<BaseResponse<User>> deleteUser(@PathVariable int id) {
		return new ResponseEntity<BaseResponse<User>>(new BaseResponse<User>("Success", HttpStatus.OK.value(), userService.deleteUser(id)),
				HttpStatus.OK);
	}
	
	
}
