package com.in28minutes.rest.webservices.restfulwebservices.dto;

import java.time.LocalDate;
import java.util.Set;

/**
 * The Class User.
 */
public class User {

	/** The id. */
	private Integer id;

	/** The name. */
	private String name;

	/** The date of birth. */
	private LocalDate dateOfBirth;

	/** The posts. */
	private Set<Post> posts;

	/**
	 * Instantiates a new user.
	 */
	public User() {
		super();
	}

	/**
	 * Instantiates a new user.
	 *
	 * @param id          the id
	 * @param name        the name
	 * @param dateOfBirth the date of birth
	 */
	public User(Integer id, String name, LocalDate dateOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * Instantiates a new user.
	 *
	 * @param id          the id
	 * @param name        the name
	 * @param dateOfBirth the date of birth
	 * @param posts       the posts
	 */
	public User(Integer id, String name, LocalDate dateOfBirth, Set<Post> posts) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.posts = posts;
	}

	/**
	 * Gets the posts.
	 *
	 * @return the posts
	 */
	public Set<Post> getPosts() {
		return posts;
	}

	/**
	 * Sets the posts.
	 *
	 * @param posts  the new posts
	 */
	public void setPosts(Set<Post> posts ) {
		this.posts = posts ;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the date of birth.
	 *
	 * @return the date of birth
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * Sets the date of birth.
	 *
	 * @param dateOfBirth the new date of birth
	 */
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, dateOfBirth=%s, posts=%s]", id, name, dateOfBirth, posts);
	}

}
