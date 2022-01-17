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
@Table(name = "oauth_access_token")
public class OauthAccessToken extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oauth_access_token_gen")
	@SequenceGenerator(name = "oauth_access_token_gen", sequenceName = "oauth_access_token_seq")
	@Column(name = "ID")
	private Integer id;

	@Column(name = "token_id")
	private String tokenId;

	@Lob
	@Column(name = "token")
	private byte[] token;

	@Column(name = "authentication_id")
	private String authenticationId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "client_id")
	private String clientId;

	@Lob
	@Column(name = "authentication")
	private byte[] authentication;

	@Column(name = "refresh_token")
	private String refreshToken;

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

	public String getAuthenticationId() {
		return authenticationId;
	}

	public void setAuthenticationId(String authenticationId) {
		this.authenticationId = authenticationId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public byte[] getAuthentication() {
		return authentication;
	}

	public void setAuthentication(byte[] authentication) {
		this.authentication = authentication;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	@Override
	public String toString() {
		return String.format(
				"OauthAccessToken [id=%s, tokenId=%s, token=%s, authenticationId=%s, userName=%s, clientId=%s, authentication=%s, refreshToken=%s]",
				id, tokenId, Arrays.toString(token), authenticationId, userName, clientId,
				Arrays.toString(authentication), refreshToken);
	}

}
