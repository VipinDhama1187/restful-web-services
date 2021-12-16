package com.in28minutes.rest.webservices.restfulwebservices.post.service;

import java.util.Set;

import com.in28minutes.rest.webservices.restfulwebservices.dto.Post;

/**
 * The Interface PostService.
 */
public interface PostService {
	
	/**
	 * Find all posts by user id.
	 *
	 * @param userId the user id
	 * @return the list
	 */
	public Set<Post> findAllPostsByUserId(Integer userId);

	/**
	 * Find one by user id.
	 *
	 * @param userId the user id
	 * @param post_id the post id
	 * @return the list
	 */
	public Post findOneByUserId(int userId, int post_id);

	/**
	 * Creates the post.
	 *
	 * @param id the id
	 * @param post the post
	 * @return the post
	 */
	public Post createPost(int userId, Post post);

}
