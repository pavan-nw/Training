package com.bt.rest.crud.security;

import java.security.Principal;

import javax.security.sasl.AuthenticationException;
import javax.ws.rs.core.SecurityContext;

public class SecurityContextImpl implements SecurityContext {

	private final SessionUser user;

	public SecurityContextImpl(SessionUser user) {
		this.user = user;
	}

	public Principal getUserPrincipal() {
		return user;
	}

	public boolean isUserInRole(String role) {
		try {

			if (user == null) {
				throw new AuthenticationException();
			}
			if (user.getPrivileges() == null) {
				throw new AuthenticationException();
			}
			if (!user.getPrivileges().contains(role)) {
				// throw new InvalidAuthorizationHeaderException();
				throw new AuthenticationException();
			}
			return user.getPrivileges().contains(role);
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean isSecure() {
		return false;
	}

	public String getAuthenticationScheme() {
		return SecurityContext.BASIC_AUTH;
	}
}