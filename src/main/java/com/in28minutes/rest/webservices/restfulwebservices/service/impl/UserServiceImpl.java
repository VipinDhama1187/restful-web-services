package com.in28minutes.rest.webservices.restfulwebservices.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.in28minutes.rest.webservices.restfulwebservices.dto.User;
import com.in28minutes.rest.webservices.restfulwebservices.exception.UserAlreadyExistsException;
import com.in28minutes.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import com.in28minutes.rest.webservices.restfulwebservices.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static List<User> userList = new ArrayList<>();

	static {
		userList.add(new User(1, "Adam", LocalDate.now()));
		userList.add(new User(2, "Eve", LocalDate.now()));
		userList.add(new User(3, "Jack", LocalDate.now()));
	}

	@Override
	public User findOne(int id) {
		return validateUserById(id);

	}

	@Override
	public List<User> findAll() {
		return userList;
	}

	@Override
	public User createUser(User user) {
		if (null == user.getId()) {
			Comparator<User> userIdComparator = Comparator.comparingInt(User::getId);
			User maxUser = userList.stream().max(userIdComparator).get();
			user.setId(maxUser.getId() + 1);
		} else {
			userList.stream().filter(u1 -> u1.getId() == user.getId()).findAny().ifPresent((s) -> {
				throw new UserAlreadyExistsException(String.format("User with id %s already exists", user.getId()));
			});
		}
		userList.add(user);
		return user;
	}

	@Override
	public User deleteUser(int id) {
		User deletedUser = validateUserById(id);
		userList.removeIf(user -> user.getId()==id);
		
		return deletedUser;
	}

	private User validateUserById(int id) {
		return userList.stream().filter(user -> user.getId() == id).findAny()
		.orElseThrow(() -> new UserNotFoundException(String.format("User Not found with id %s", id)));
	}

}
