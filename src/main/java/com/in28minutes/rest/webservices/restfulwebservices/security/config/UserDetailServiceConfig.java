package com.in28minutes.rest.webservices.restfulwebservices.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@SuppressWarnings("deprecation")
@Configuration
public class UserDetailServiceConfig {

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
	 * JDBC implementation
	 * 
	 * @return
	 *//*
		 * @Bean public UserDetailsService userDetailsServiceJdbc() { UserDetailsManager
		 * userDetailsService = new JdbcUserDetailsManager(dataSource); //UserDetails
		 * userDetails = userDetailsService.loadUserByUsername("");
		 * //userDetailsService.createUser(userDetails); return userDetailsService; }
		 */

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
