package com.in28minutes.rest.webservices.restfulwebservices.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.restfulwebservices.bean.HelloWorldBean;
import com.in28minutes.rest.webservices.restfulwebservices.dto.BaseResponse;

import java.util.StringJoiner;

@RestController
public class HelloWorldController {

	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World!";
	}

	@GetMapping("/hello-world-bean/{name}")
	public ResponseEntity<BaseResponse<HelloWorldBean>> helloWorldBean(@PathVariable String name) {
		return new ResponseEntity<BaseResponse<HelloWorldBean>>(
				new BaseResponse<HelloWorldBean>("Success", 200,
						new HelloWorldBean(new StringJoiner(" ").add("Hello World!").add(name).toString())),
				HttpStatus.OK);
	}

}
