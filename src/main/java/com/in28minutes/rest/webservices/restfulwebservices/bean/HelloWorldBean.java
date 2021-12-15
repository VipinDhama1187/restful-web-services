/**
 * 
 */
package com.in28minutes.rest.webservices.restfulwebservices.bean;

/**
 * @author a13400520
 *
 */
public class HelloWorldBean {

	private String message;

	public HelloWorldBean(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return String.format("HelloWorldBean [message=%s]", this.message);
	}

}
