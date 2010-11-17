package com.flabot.remotestorage.auth.data;

import com.flabot.remotestorage.auth.constants.AuthenticationConstants;

public class PasswordAuthenticationData extends AuthenticationData {

	private String username;
	private String password;

	public PasswordAuthenticationData(){
		this.setType(AuthenticationConstants.PASSWORD_AUTHENTICATION);
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
	
}
