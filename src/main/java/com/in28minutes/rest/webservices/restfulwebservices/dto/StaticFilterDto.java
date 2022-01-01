package com.in28minutes.rest.webservices.restfulwebservices.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Class SomeMessage.
 */
public class StaticFilterDto {
	
	/** The value 1. */
	private String value1;
	
	/** The value 2. */
	/**
	 * Static filter on the property
	 */
	@JsonIgnore
	private String value2;
	
	/** The value 3. */
	private String value3;

	/**
	 * Instantiates a new some message.
	 *
	 * @param value1 the value 1
	 * @param value2 the value 2
	 * @param value3 the value 3
	 */
	public StaticFilterDto(String value1, String value2, String value3) {
		this.value1 = value1;
		this.value2 = value2;
		this.value3 = value3;
	}

	/**
	 * Gets the value 1.
	 *
	 * @return the value 1
	 */
	public String getValue1() {
		return value1;
	}

	/**
	 * Sets the value 1.
	 *
	 * @param value1 the new value 1
	 */
	public void setValue1(String value1) {
		this.value1 = value1;
	}

	/**
	 * Gets the value 2.
	 *
	 * @return the value 2
	 */
	public String getValue2() {
		return value2;
	}

	/**
	 * Sets the value 2.
	 *
	 * @param value2 the new value 2
	 */
	public void setValue2(String value2) {
		this.value2 = value2;
	}

	/**
	 * Gets the value 3.
	 *
	 * @return the value 3
	 */
	public String getValue3() {
		return value3;
	}

	/**
	 * Sets the value 3.
	 *
	 * @param value3 the new value 3
	 */
	public void setValue3(String value3) {
		this.value3 = value3;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return String.format("SomeMessage [value1=%s, value2=%s, value3=%s]", value1, value2, value3);
	}

}
