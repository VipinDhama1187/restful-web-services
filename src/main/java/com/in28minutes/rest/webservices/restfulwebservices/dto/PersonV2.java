package com.in28minutes.rest.webservices.restfulwebservices.dto;

/**
 * The Class PersonV1.
 */
public class PersonV2 {
	
	/** The name. */
	private Name name;

	/**
	 * Instantiates a new person V 1.
	 */
	public PersonV2() {
		super();
	}

	/**
	 * Instantiates a new person V 1.
	 *
	 * @param name the name
	 */
	public PersonV2(Name name) {
		super();
		this.name = name;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public Name getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(Name name) {
		this.name = name;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return String.format("PersonV1 [name=%s]", name);
	}

}
