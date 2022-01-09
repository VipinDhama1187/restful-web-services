package com.in28minutes.rest.webservices.restfulwebservices.dto;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public interface SecurityUser extends UserDetails {
	@Override
	public default Collection<? extends GrantedAuthority> getAuthorities() {
		
		return List.of(()->"read", ()->"write");
				//Arrays.asList(new SimpleGrantedAuthority("read"), new SimpleGrantedAuthority("write"));
	}

	@Override
	public default boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public default boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public default boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public default boolean isEnabled() {
		return true;
	}
}
