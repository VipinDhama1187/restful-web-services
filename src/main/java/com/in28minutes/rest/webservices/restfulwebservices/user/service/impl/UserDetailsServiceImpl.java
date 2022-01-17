package com.in28minutes.rest.webservices.restfulwebservices.user.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.in28minutes.rest.webservices.restfulwebservices.entity.MyUserDetails;
import com.in28minutes.rest.webservices.restfulwebservices.entity.User;
import com.in28minutes.rest.webservices.restfulwebservices.exception.UserAlreadyExistsException;
import com.in28minutes.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import com.in28minutes.rest.webservices.restfulwebservices.user.repo.UserRepository;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsManager{// UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder userPasswordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Optional<User> optionalUser = 	 userRepository.findUserByUsername(username);
	if(optionalUser.isPresent())
		return new MyUserDetails(optionalUser.get());
	else
		throw new UsernameNotFoundException(String.format("User Not found with username %s", username));
	}

	@Override
	public void createUser(UserDetails user) {
		Optional<User> optionalUser = userRepository.findUserByUsername(user.getUsername());
		if(optionalUser.isPresent())
			throw new UserAlreadyExistsException(user.getUsername());
		else {
			encodePassword(((MyUserDetails)user).getUser());
			userRepository.save(((MyUserDetails)user).getUser());
		}
	}

	@Override
	public void updateUser(UserDetails user) {
		Optional<User> optionalUser = userRepository.findUserByUsername(user.getUsername());
		if(!optionalUser.isPresent())
			throw new UserNotFoundException(user.getUsername());
		else {
			User newUser = ((MyUserDetails)user).getUser();
			encodePassword(newUser);
			newUser.setId(optionalUser.get().getId());
			userRepository.save(newUser);
		}
		
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean userExists(String username) {
		return userRepository.findUserByUsername(username).isPresent();
	}
	
	private void encodePassword(User user) {
		user.setPassword(userPasswordEncoder.encode(user.getPassword()));
	}
	

}
