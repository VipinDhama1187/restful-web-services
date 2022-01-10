package com.in28minutes.rest.webservices.restfulwebservices.post.service.impl;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.rest.webservices.restfulwebservices.dto.Post;
import com.in28minutes.rest.webservices.restfulwebservices.entity.User;
import com.in28minutes.rest.webservices.restfulwebservices.exception.PostNotFoundException;
import com.in28minutes.rest.webservices.restfulwebservices.post.service.PostService;
import com.in28minutes.rest.webservices.restfulwebservices.user.service.UserService;
import com.in28minutes.rest.webservices.restfulwebservices.user.service.impl.UserServiceImpl;

/**
 * The Class PostServiceImpl.
 */
@Service("postService")
public class PostServiceImpl implements PostService {

	/** The posts. */
	private static Set<Post> posts = new HashSet<>();

	/** The user service. */
	@Autowired
	private UserService userService;

	static {
		posts.add(new Post(1, "my 1st post"));
		posts.add(new Post(2, "my 2nd post"));
		posts.add(new Post(3, "my 3rd post"));
		List<User> users = UserServiceImpl.userList;
		users.stream().forEach(u -> u.setPosts(posts));
	}

	/**
	 * Find all posts by user id.
	 *
	 * @param userId the user id
	 * @return the list
	 */
	@Override
	public Set<Post> findAllPostsByUserId(Integer userId) {
		User user = userService.validateUserById(userId);
		if (null != user.getPosts() && !user.getPosts().isEmpty())
			return user.getPosts();
		else
			throw new PostNotFoundException(String.format("No post available for user id %s", userId));
	}

	/**
	 * Find one by user id.
	 *
	 * @param userId  the user id
	 * @param post_id the post id
	 * @return the post
	 */
	@Override
	public Post findOneByUserId(int userId, int post_id) {
		User user = userService.validateUserById(userId);
		if (null != user.getPosts() && !user.getPosts().isEmpty()) {
			return user.getPosts().stream().filter(post -> post.getPostId() == post_id).findAny().orElseThrow(
					() -> new PostNotFoundException(String.format("No post available for user id %s", userId)));
		} else
			throw new PostNotFoundException(String.format("No post available for user id %s", userId));
	}

	/**
	 * Creates the post.
	 *
	 * @param userId the user id
	 * @param post   the post
	 * @return the post
	 */
	@Override
	public Post createPost(int userId, Post post) {
		Post newPost = post;
		User user = userService.validateUserById(userId);
		if (null == post.getPostId()) {
			Comparator<Post> postComparator = Comparator.comparingInt(Post::getPostId);
			Post maxPost = posts.stream().max(postComparator).get();
			newPost.setPostId(maxPost.getPostId() + 1);
		} else {
			newPost = posts.stream().filter(p -> p.equals(post)).findAny().orElse(post);
		}
		posts.add(newPost);
		user.getPosts().add(newPost);
		return newPost;
	}

}
