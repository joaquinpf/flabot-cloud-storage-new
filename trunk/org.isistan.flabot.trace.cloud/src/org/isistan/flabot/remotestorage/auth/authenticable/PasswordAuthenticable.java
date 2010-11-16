package com.flabot.remotestorage.auth.authenticable;
import com.flabot.remotestorage.auth.data.PasswordAuthenticationData;
import com.flabot.remotestorage.exception.AuthenticationException;



public interface PasswordAuthenticable extends Authenticable {

	public void passwordAuthentication(PasswordAuthenticationData authData) throws AuthenticationException;
	
}
