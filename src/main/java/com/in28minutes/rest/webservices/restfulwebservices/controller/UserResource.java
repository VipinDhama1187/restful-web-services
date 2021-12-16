package com.in28minutes.rest.webservices.restfulwebservices.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
import com.in28minutes.rest.webservices.restfulwebservices.user.service.UserService;

/**
 * The Class UserResource.
 */
@RestController
public class UserResource {

	/** The user service. */
	@Autowired
	private UserService userService;

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
	public ResponseEntity<EntityModel<BaseResponse<User>>> getUser(@PathVariable int id) {
		EntityModel<BaseResponse<User>> entityModal = EntityModel.of(new BaseResponse<User>("Success", HttpStatus.OK.value(), userService.findOne(id)));
		
		WebMvcLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).getUsers());
		entityModal.add(linkBuilder.withRel("all-users"));
		return new ResponseEntity<EntityModel<BaseResponse<User>>>((entityModal),
				HttpStatus.OK);
	}
	
	/**
	 * Creates the user.
	 *
	 * @param user the user
	 * @return the response entity
	 */
	@SuppressWarnings("static-access")
	@PostMapping("/users")
	public ResponseEntity<BaseResponse<User>> createUser(@Valid @RequestBody User user) {
		User savedUser = userService.createUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return new ResponseEntity<BaseResponse<User>>(new BaseResponse<User>("Success", HttpStatus.CREATED.value(), savedUser),
				HttpStatus.CREATED).created(location).build();
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
