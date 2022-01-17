package com.in28minutes.rest.webservices.restfulwebservices.oauth.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.util.StringUtils;

public class AuthorizationClientDetails implements ClientDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final OauthClientDetails oauthClientDetails;

	public AuthorizationClientDetails(OauthClientDetails oauthClientDetails) {
		this.oauthClientDetails = oauthClientDetails;
	}

	@Override
	public String getClientId() {
		return this.oauthClientDetails.getClientId();
	}

	@Override
	public Set<String> getResourceIds() {
		if (this.oauthClientDetails.getResourceIds().contains(",")) {
			String[] resourceIdArray = StringUtils.split(this.oauthClientDetails.getResourceIds(), ",");

			Set<String> resourceIdSet = new HashSet<>();
			for (String resourceId : resourceIdArray) {
				resourceIdSet.add(resourceId);
			}
			return resourceIdSet;
		} else {
			return Set.of(this.oauthClientDetails.getResourceIds());
		}
	}

	@Override
	public boolean isSecretRequired() {
		return true;
	}

	@Override
	public String getClientSecret() {
		return this.oauthClientDetails.getClientSecret();
	}

	@Override
	public boolean isScoped() {
		return true;
	}

	@Override
	public Set<String> getScope() {

		if (this.oauthClientDetails.getScope().contains(",")) {
			String[] scopeArray = StringUtils.split(this.oauthClientDetails.getScope(), ",");
			Set<String> scopeSet = new HashSet<>();
			for (String scope : scopeArray) {
				scopeSet.add(scope);
			}
			return scopeSet;
		} else {
			return Set.of(this.oauthClientDetails.getScope());
		}
	}

	@Override
	public Set<String> getAuthorizedGrantTypes() {
		if (this.oauthClientDetails.getAuthorizedGrantTypes().contains(",")) {
			String[] authorizedGrantTypesArray = StringUtils.split(this.oauthClientDetails.getAuthorizedGrantTypes(),
					",");

			Set<String> authorizedGrantTypesSet = new HashSet<>();
			for (String authorizedGrantType : authorizedGrantTypesArray) {
				authorizedGrantTypesSet.add(authorizedGrantType);
			}
			return authorizedGrantTypesSet;
		} else {
			return Set.of(this.oauthClientDetails.getAuthorizedGrantTypes());
		}
	}

	@Override
	public Set<String> getRegisteredRedirectUri() {
		return Set.of("http://localhost:8091");
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return List.of(() -> this.oauthClientDetails.getAuthorities());
	}

	@Override
	public Integer getAccessTokenValiditySeconds() {
		return this.oauthClientDetails.getAccessTokenValidity();
	}

	@Override
	public Integer getRefreshTokenValiditySeconds() {

		return this.oauthClientDetails.getRefreshTokenValidity();
	}

	@Override
	public boolean isAutoApprove(String scope) {
		return false;
	}

	@Override
	public Map<String, Object> getAdditionalInformation() {
		return null;
	}

}
