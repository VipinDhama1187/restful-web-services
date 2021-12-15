package com.in28minutes.rest.webservices.restfulwebservices.service;

import java.util.List;

import com.in28minutes.rest.webservices.restfulwebservices.dto.User;

/**
 * @author a13400520
 *
 */
public interface UserService {

	
	public User findOne(int id);

	/**
	 * @return
	 */
	public List<User> findAll();

	
	public User createUser(User user);

	public User deleteUser(int id);

}
