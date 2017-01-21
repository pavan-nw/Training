package com.bt.rest.crud.security;

import java.security.Principal;
import java.util.List;

public class SessionUser implements Principal {
	private String name;
	private List<String> privileges;
	
	public SessionUser() {
		
	}
	
	public SessionUser(String user, List<String> privileges) {
		this.name = user;
		this.privileges = privileges;
	}
	
	@Override
	public String getName() {
		return name;
	}

	public List<String> getPrivileges() {
		return privileges;
	}
	
}
