package com.in28minutes.rest.webservices.restfulwebservices.exception;

/**
 * The Class PostNotFoundException.
 */
public class PostNotFoundException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new post not found exception.
	 *
	 * @param message the message
	 */
	public PostNotFoundException(String message) {
		super(message);
	}

}
