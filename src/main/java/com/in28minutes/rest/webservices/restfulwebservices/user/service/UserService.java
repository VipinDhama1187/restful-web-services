package com.in28minutes.rest.webservices.restfulwebservices.user.service;

import java.util.List;

import com.in28minutes.rest.webservices.restfulwebservices.entity.User;

/**
 * The Interface UserService.
 *
 */
public interface UserService {

	
	/**
	 * Find one.
	 *
	 * @param id the id
	 * @return the user
	 */
	public User findOne(int id);

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<User> findAll();

	
	/**
	 * Creates the user.
	 *
	 * @param user the user
	 * @return the user
	 */
	public User createUser(User user);

	/**
	 * Delete user.
	 *
	 * @param id the id
	 * @return the user
	 */
	public User deleteUser(int id);

	/**
	 * Validate user by id.
	 *
	 * @param id the id
	 * @return the user
	 */
	public User validateUserById(int id);

}
