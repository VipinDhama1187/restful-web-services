package com.in28minutes.rest.webservices.restfulwebservices.oauth.client.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.rest.webservices.restfulwebservices.oauth.entity.OauthClientDetails;


@Repository("clientDetailsServiceRepository")
public interface ClientDetailsServiceRepository extends JpaRepository<OauthClientDetails, Integer> {

	Optional<OauthClientDetails> findOauthClientDetailsByClientId(String clientId);
}
