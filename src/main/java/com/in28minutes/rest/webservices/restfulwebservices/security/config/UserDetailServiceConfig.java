package com.in28minutes.rest.webservices.restfulwebservices.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@SuppressWarnings("deprecation")
@Configuration
public class UserDetailServiceConfig {

	/*
	 * @Autowired private DataSource dataSource;
	 */

	/**
	 * In memory implementation
	 * 
	 * @return
	 */
	// @Bean
	public UserDetailsService userDetailsService() {
		UserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
		UserDetails userDetails = User.builder().username("bill").password("12345").authorities("read").build();
		userDetailsService.createUser(userDetails);
		return userDetailsService;
	}

	/**
	 * JDBC implementation used for creating the user and modifying the users it
	 * also helps u to get validate the users by username and password
	 * 
	 * @return
	 */

	/*
	 * @Bean("userDetailsManager") public UserDetailsManager
	 * userDetailsServiceJdbc() { return new JdbcUserDetailsManager(dataSource); }
	 */
	// UserDetails }

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
