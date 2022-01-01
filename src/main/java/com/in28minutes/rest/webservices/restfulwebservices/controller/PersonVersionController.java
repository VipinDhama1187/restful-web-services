package com.in28minutes.rest.webservices.restfulwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.restfulwebservices.dto.Name;
import com.in28minutes.rest.webservices.restfulwebservices.dto.PersonV1;
import com.in28minutes.rest.webservices.restfulwebservices.dto.PersonV2;

@RestController
public class PersonVersionController {

	@GetMapping("/v1/person")
	public PersonV1 getPersonV1() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping("/v2/person")
	public PersonV2 getPersonV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

	@GetMapping(value = "/person/param", params = "version=1")
	public PersonV1 getPersonParamV1() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping(value = "/person/param", params = "version=2")
	public PersonV2 getPersonParamsV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

	@GetMapping(value = "/person/header", headers = "X-API-VERSION1")
	public PersonV1 getPersonHeaderV1() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping(value = "/person/header", headers = "X-API-VERSION2")
	public PersonV2 getPersonHeaderV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
	public PersonV1 getPersonProducesV1() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
	public PersonV2 getPersonProducesV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

}
