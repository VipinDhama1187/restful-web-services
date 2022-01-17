package com.in28minutes.rest.webservices.restfulwebservices.oauth.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.in28minutes.rest.webservices.restfulwebservices.entity.BaseEntity;

@Entity
@Table(name = "oauth_refresh_token")
public class OauthRefreshToken extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oauth_refresh_token_gen")
	@SequenceGenerator(name = "oauth_refresh_token_gen", sequenceName = "oauth_refresh_token_seq")
	@Column(name = "ID")
	private Integer id;

	@Column(name = "token_id")
	private String tokenId;

	@Lob
	@Column(name = "token")
	private byte[] token;

	@Lob
	@Column(name = "authentication")
	private byte[] authentication;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public byte[] getToken() {
		return token;
	}

	public void setToken(byte[] token) {
		this.token = token;
	}

	public byte[] getAuthentication() {
		return authentication;
	}

	public void setAuthentication(byte[] authentication) {
		this.authentication = authentication;
	}

	@Override
	public String toString() {
		return String.format("OauthRefreshToken [id=%s, tokenId=%s, token=%s, authentication=%s]", id, tokenId,
				Arrays.toString(token), Arrays.toString(authentication));
	}

}