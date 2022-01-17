package com.in28minutes.rest.webservices.restfulwebservices.oauth.client.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import com.in28minutes.rest.webservices.restfulwebservices.oauth.client.repo.ClientDetailsServiceRepository;
import com.in28minutes.rest.webservices.restfulwebservices.oauth.entity.AuthorizationClientDetails;
import com.in28minutes.rest.webservices.restfulwebservices.oauth.entity.OauthClientDetails;

@Service("clientDetailsServiceImpl")
public class ClientDetailsServiceImpl implements ClientDetailsService {
	
	@Autowired
	private ClientDetailsServiceRepository  clientDetailsServiceRepository;

	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		Optional<OauthClientDetails> optionalOauthClientDetails = clientDetailsServiceRepository.findOauthClientDetailsByClientId(clientId);
		
		if(optionalOauthClientDetails.isPresent())
			return new AuthorizationClientDetails(optionalOauthClientDetails.get());
		else
			throw new ClientRegistrationException(String.format("Client is not registered with client id %s", clientId));
	}

}
