package com.in28minutes.rest.webservices.restfulwebservices.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.in28minutes.rest.webservices.restfulwebservices.dto.Post;
import com.in28minutes.rest.webservices.restfulwebservices.dto.SecurityUser;

/**
 * The Class User.
 */
@Entity
@Table(name = "USERS")
@SecondaryTables({
    @SecondaryTable(name="authorities")
})
public class User extends BaseEntity implements SecurityUser {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ_GEN")
	@SequenceGenerator(sequenceName = "USERS_SEQ", name = "USERS_SEQ_GEN")
	private Integer id;

	/** The name. */
	@Size(min = 2, message = "name should be min of 2 characters")
	@Column(name = "username", nullable = false, unique = true)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "ENABLED", nullable = false)
	private Integer enabled;

	@NotNull
    @Column(table="authorities")
    private String authority;

	/** The date of birth. */
	@Past
	@Transient
	private LocalDate dateOfBirth;

	/** The posts. */
	@Transient
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
	 * @param username    the name
	 * @param dateOfBirth the date of birth
	 */
	public User(Integer id, String username, LocalDate dateOfBirth) {
		super();
		this.id = id;
		this.username = username;
		this.dateOfBirth = dateOfBirth;
	}

	public User(Integer id, String username, String password, Integer enabled, LocalDate dateOfBirth) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * Instantiates a new user.
	 *
	 * @param id          the id
	 * @param username    the name
	 * @param dateOfBirth the date of birth
	 * @param posts       the posts
	 */
	public User(Integer id, String username, LocalDate dateOfBirth, Set<Post> posts) {
		super();
		this.id = id;
		this.username = username;
		this.dateOfBirth = dateOfBirth;
		this.posts = posts;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
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
	 * @param posts the new posts
	 */
	public void setPosts(Set<Post> posts) {
		this.posts = posts;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return String.format(
				"User [id=%s, username=%s, password=%s, enabled=%s, authority=%s, dateOfBirth=%s, posts=%s]", id,
				username, password, enabled, authority, dateOfBirth, posts);
	}

	

}
