package com.in28minutes.rest.webservices.restfulwebservices.security.authentication.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserDetailsManager userDetailsServiceImpl;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		/**
		 * 3 condition where Authentication works here your authentication logic will be
		 * implemented
		 * 
		 * if your request is authenticated then return a fully authenticated
		 * Authentication Instance
		 * 
		 * if the request is not authenticated then throw AuthenticationException
		 * 
		 * if authentication is not supported by this authentication provider then
		 * return null
		 */

		String userName = authentication.getName();
		String password = (String) authentication.getCredentials();
		UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(userName);

		if (null != userDetails) {
			if (passwordEncoder.matches(password, userDetails.getPassword())) {
				return new UsernamePasswordAuthenticationToken(userName, password, userDetails.getAuthorities());
			}
			throw new BadCredentialsException("Credentials not match!");
		}

		return null;
	}

	@Override
	public boolean supports(Class<?> authenticationType) {
		/**
		 * this method helps you in figuring out whether your authentication is
		 * supported or not
		 * 
		 * this authentication parameter in supports method is the type of
		 * Authentication here
		 */
		return UsernamePasswordAuthenticationToken.class.equals(authenticationType);
//		return false;
	}

}
