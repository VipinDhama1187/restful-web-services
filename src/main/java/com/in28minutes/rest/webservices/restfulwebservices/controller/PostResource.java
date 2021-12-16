package com.in28minutes.rest.webservices.restfulwebservices.controller;

import java.net.URI;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.webservices.restfulwebservices.dto.BaseResponse;
import com.in28minutes.rest.webservices.restfulwebservices.dto.Post;
import com.in28minutes.rest.webservices.restfulwebservices.post.service.PostService;

/**
 * The Class PostResource.
 */
@RestController
public class PostResource {

	/** The post service. */
	@Autowired
	private PostService postService;

	/**
	 * Find one by user id.
	 *
	 * @param id      the id
	 * @param post_id the post id
	 * @return the response entity
	 */
	@GetMapping("/users/{id}/posts/{post_id}")
	public ResponseEntity<BaseResponse<Post>> findOneByUserId(@PathVariable int id, @PathVariable int post_id) {
		return new ResponseEntity<BaseResponse<Post>>(
				new BaseResponse<Post>("Success", HttpStatus.OK.value(), postService.findOneByUserId(id, post_id)),
				HttpStatus.OK);
	}

	/**
	 * Gets the all posts by user.
	 *
	 * @param id the id
	 * @return the all posts by user
	 */
	@GetMapping("/users/{id}/posts")
	public ResponseEntity<BaseResponse<Set<Post>>> getAllPostsByUser(@PathVariable int id) {
		return new ResponseEntity<BaseResponse<Set<Post>>>(
				new BaseResponse<Set<Post>>("Success", HttpStatus.OK.value(), postService.findAllPostsByUserId(id)),
				HttpStatus.OK);
	}

	/**
	 * Creates the user.
	 *
	 * @param user the user
	 * @return the response entity
	 */
	@SuppressWarnings("static-access")
	@PostMapping("/users/{id}/posts")
	public ResponseEntity<BaseResponse<Post>> createUser(@PathVariable int id, @RequestBody Post post) {
		Post savedPost = postService.createPost(id, post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{post_id}").buildAndExpand(savedPost.getPostId())
				.toUri();
		return new ResponseEntity<BaseResponse<Post>>(
				new BaseResponse<Post>("Success", HttpStatus.CREATED.value(), savedPost), HttpStatus.CREATED)
						.created(location).build();
	}

}
