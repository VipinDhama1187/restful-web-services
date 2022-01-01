package com.in28minutes.rest.webservices.restfulwebservices.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.in28minutes.rest.webservices.restfulwebservices.dto.DynamicFilterDto;
import com.in28minutes.rest.webservices.restfulwebservices.dto.StaticFilterDto;

@RestController
public class FilterController {

	@GetMapping("/getStaticFilteredValue")
	public StaticFilterDto getAppliedFilteredMessage() {
		return new StaticFilterDto("value1", "value2", "value3");
	}

	@GetMapping("/getDynamicFilteredList")
	public MappingJacksonValue getDynamicFilteredList() {
		List<DynamicFilterDto> asList = Arrays.asList(new DynamicFilterDto("value1", "value2", "value3"),
				new DynamicFilterDto("value1", "value2", "value3"));
		
		SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("value1", "value2");
		
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("simpleDynamicFilter", simpleBeanPropertyFilter );
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(asList);
		
		mappingJacksonValue.setFilters(filterProvider);
		
		return mappingJacksonValue;
	}

}
