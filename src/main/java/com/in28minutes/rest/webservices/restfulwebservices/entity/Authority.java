/*
 * package com.in28minutes.rest.webservices.restfulwebservices.entity;
 * 
 * import javax.persistence.Column; import javax.persistence.Entity; import
 * javax.persistence.FetchType; import javax.persistence.GeneratedValue; import
 * javax.persistence.GenerationType; import javax.persistence.Id; import
 * javax.persistence.JoinColumn; import javax.persistence.ManyToOne; import
 * javax.persistence.SequenceGenerator; import javax.persistence.Table;
 * 
 * @Entity
 * 
 * @Table(name = "AUTHORITIES") public class Authority extends BaseEntity{
 * 
 *//**
	* 
	*/
/*
 * private static final long serialVersionUID = 1L;
 *//**
	 * The id.
	 *//*
		 * @Id
		 * 
		 * @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
		 * "AUTHORITIES_SEQ_GEN")
		 * 
		 * @SequenceGenerator(sequenceName = "AUTHORITIES_SEQ", name =
		 * "AUTHORITIES_SEQ_GEN") private Integer id;
		 * 
		 * @ManyToOne(fetch = FetchType.LAZY)
		 * 
		 * @JoinColumn(name = "user.username") private User user;
		 * 
		 * @Column(name="AUTHORITY", nullable = false) private String AUTHORITY;
		 * 
		 * public Integer getId() { return id; }
		 * 
		 * public void setId(Integer id) { this.id = id; }
		 * 
		 * 
		 * 
		 * public User getUser() { return user; }
		 * 
		 * public void setUser(User user) { this.user = user; }
		 * 
		 * public String getAUTHORITY() { return AUTHORITY; }
		 * 
		 * public void setAUTHORITY(String aUTHORITY) { AUTHORITY = aUTHORITY; }
		 * 
		 * @Override public String toString() { return
		 * String.format("Authorities [id=%s, user=%s, AUTHORITY=%s]", id, user,
		 * AUTHORITY); }
		 * 
		 * 
		 * 
		 * }
		 */