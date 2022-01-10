package com.in28minutes.rest.webservices.restfulwebservices.user.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.rest.webservices.restfulwebservices.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	Optional<User> findUserByUsername(String username);

}
