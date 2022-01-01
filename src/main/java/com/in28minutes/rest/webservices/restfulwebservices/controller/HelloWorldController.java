package com.in28minutes.rest.webservices.restfulwebservices.controller;

import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.restfulwebservices.bean.HelloWorldBean;
import com.in28minutes.rest.webservices.restfulwebservices.dto.BaseResponse;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;

	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World!";
	}
	
	@GetMapping("/hello-world-internationalized")
	public String helloWorldInternationalized() {
		return messageSource.getMessage("good.morning.message", null, "default message", LocaleContextHolder.getLocale());
		//en-Hello World!
		//nl - Goede Morgen
		//fr - Bonjor
		//return "Hello World!";
	}

	@GetMapping("/hello-world-bean/{name}")
	public ResponseEntity<BaseResponse<HelloWorldBean>> helloWorldBean(@PathVariable String name) {
		return new ResponseEntity<BaseResponse<HelloWorldBean>>(
				new BaseResponse<HelloWorldBean>("Success", 200,
						new HelloWorldBean(new StringJoiner(" ").add("Hello World!").add(name).toString())),
				HttpStatus.OK);
	}

}
