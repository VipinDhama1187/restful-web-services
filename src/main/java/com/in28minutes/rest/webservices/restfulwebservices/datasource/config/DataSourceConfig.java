package com.in28minutes.rest.webservices.restfulwebservices.datasource.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

	@Value("${spring.datasource.url}")
	private String dbUrl;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;

	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;

	@Value("${spring.jpa.properties.hibernate.dialect}")
	private String dialect;

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		return DataSourceBuilder.create()
		.url(dbUrl)
		.driverClassName(driverClassName)
		.username(username)
		.password(password)
		.build();
	}

}
