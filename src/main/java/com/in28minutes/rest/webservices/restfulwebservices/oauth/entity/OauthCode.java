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
@Table(name="oauth_code")
public class OauthCode extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oauth_code_gen")
	@SequenceGenerator(name = "oauth_code_gen", sequenceName = "oauth_code_seq")
	@Column(name = "ID")
	private Integer id;
	
	@Column(name="code")
	private String code;
	
	@Lob
	@Column(name="authentication")
	private byte[] authentication;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public byte[] getAuthentication() {
		return authentication;
	}

	public void setAuthentication(byte[] authentication) {
		this.authentication = authentication;
	}

	@Override
	public String toString() {
		return String.format("OauthCode [id=%s, code=%s, authentication=%s]", id, code,
				Arrays.toString(authentication));
	}
	
}