package com.in28minutes.rest.webservices.restfulwebservices.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
public class UserDetailServiceConfig extends WebSecurityConfigurerAdapter {

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
		// return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
		http.csrf().disable().authorizeRequests().mvcMatchers("/user").permitAll().anyRequest().authenticated();
	}

}
