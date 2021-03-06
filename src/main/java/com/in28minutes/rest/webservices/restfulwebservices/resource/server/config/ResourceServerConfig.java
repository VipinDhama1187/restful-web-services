package com.in28minutes.rest.webservices.restfulwebservices.resource.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {


	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId("resource-server-rest-api");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		/*
		 * http.authorizeRequests().antMatchers("/hello-world-bean").hasAuthority("read"
		 * );
		 */
		 http.authorizeRequests()
			.mvcMatchers(HttpMethod.POST, "/user").permitAll(). and().authorizeRequests().anyRequest().authenticated();
	}
	
	
}
