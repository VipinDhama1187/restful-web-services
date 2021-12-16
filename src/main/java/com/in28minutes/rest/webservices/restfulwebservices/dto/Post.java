package com.in28minutes.rest.webservices.restfulwebservices.dto;

import java.util.Objects;

/**
 * The Class Post.
 */
public class Post {

	/** The post id. */
	private Integer postId;

	/** The description. */
	private String description;

	/**
	 * Instantiates a new post.
	 */
	public Post() {
		super();
	}

	/**
	 * Instantiates a new post.
	 *
	 * @param postId      the post id
	 * @param description the description
	 */
	public Post(Integer postId, String description) {
		super();
		this.postId = postId;
		this.description = description;
	}

	/**
	 * Gets the post id.
	 *
	 * @return the post id
	 */
	public Integer getPostId() {
		return postId;
	}

	/**
	 * Sets the post id.
	 *
	 * @param postId the new post id
	 */
	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Equals.
	 *
	 * @param post the post
	 * @return true, if successful
	 */
	public boolean equals(Post post) {
		if (null == post)
			return false;
		else
			return Objects.equals(this.getPostId(), post.getPostId());
	}

	@Override
	public String toString() {
		return String.format("Post [postId=%s, description=%s]", postId, description);
	}

}
