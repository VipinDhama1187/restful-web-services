package com.in28minutes.rest.webservices.restfulwebservices.oauth.entity;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.in28minutes.rest.webservices.restfulwebservices.entity.BaseEntity;

@Entity
@Table(name = "oauth_client_details")
public class OauthClientDetails extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oauth_client_details_gen")
	@SequenceGenerator(name = "oauth_client_details_gen", sequenceName = "oauth_client_details_seq")
	@Column(name = "ID")
	private Integer id;

	@Column(name = "client_id")
	private String clientId;

	@Column(name = "client_name")
	private String clientName;

	@Column(name = "resource_ids")
	private String resourceIds;

	@Column(name = "client_secret")
	private String clientSecret;

	@Column(name = "scope")
	private String scope;

	@Column(name = "authorized_grant_types")
	private String authorizedGrantTypes;

	@Column(name = "web_server_redirect_uri")
	private String webServerRedirectUri;

	@Column(name = "authorities")
	private String authorities;

	@Column(name = "access_token_validity", length = 11)
	private Integer accessTokenValidity;

	@Column(name = "refresh_token_validity", length = 11)
	private Integer refreshTokenValidity;

	@Column(name = "additional_information", length = 4096)
	private String additionalInformation;

	@Column(name = "autoapprove", columnDefinition = "SMALLINT")
	private Short autoapprove;

	@Column(name = "uuid")
	private String uuid;

	@Column
	private Date created;

	@Column(columnDefinition = "boolean default true")
	private Boolean enabled;

	@Transient
	private String[] scopes;

	@Transient
	private String[] grantTypes;

	@Transient
	private String ownerEmail;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getResourceIds() {
		return resourceIds;
	}

	public void setResourceIds(String resourceIds) {
		this.resourceIds = resourceIds;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getAuthorizedGrantTypes() {
		return authorizedGrantTypes;
	}

	public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
		this.authorizedGrantTypes = authorizedGrantTypes;
	}

	public String getWebServerRedirectUri() {
		return webServerRedirectUri;
	}

	public void setWebServerRedirectUri(String webServerRedirectUri) {
		this.webServerRedirectUri = webServerRedirectUri;
	}

	public String getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

	public Integer getAccessTokenValidity() {
		return accessTokenValidity;
	}

	public void setAccessTokenValidity(Integer accessTokenValidity) {
		this.accessTokenValidity = accessTokenValidity;
	}

	public Integer getRefreshTokenValidity() {
		return refreshTokenValidity;
	}

	public void setRefreshTokenValidity(Integer refreshTokenValidity) {
		this.refreshTokenValidity = refreshTokenValidity;
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	public Short getAutoapprove() {
		return autoapprove;
	}

	public void setAutoapprove(Short autoapprove) {
		this.autoapprove = autoapprove;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String[] getScopes() {
		return scopes;
	}

	public void setScopes(String[] scopes) {
		this.scopes = scopes;
	}

	public String[] getGrantTypes() {
		return grantTypes;
	}

	public void setGrantTypes(String[] grantTypes) {
		this.grantTypes = grantTypes;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	@Override
	public String toString() {
		return String.format(
				"OauthClientDetails [id=%s, clientId=%s, clientName=%s, resourceIds=%s, clientSecret=%s, scope=%s, authorizedGrantTypes=%s, webServerRedirectUri=%s, authorities=%s, accessTokenValidity=%s, refreshTokenValidity=%s, additionalInformation=%s, autoapprove=%s, uuid=%s, enabled=%s, scopes=%s, grantTypes=%s, ownerEmail=%s]",
				id, clientId, clientName, resourceIds, clientSecret, scope, authorizedGrantTypes, webServerRedirectUri,
				authorities, accessTokenValidity, refreshTokenValidity, additionalInformation, autoapprove, uuid,
				enabled, Arrays.toString(scopes), Arrays.toString(grantTypes), ownerEmail);
	}

}