package com.flabot.remotestorage.auth.authenticator;

import com.flabot.remotestorage.auth.authenticable.Authenticable;
import com.flabot.remotestorage.auth.authenticable.PasswordAuthenticable;
import com.flabot.remotestorage.auth.data.AuthenticationData;
import com.flabot.remotestorage.auth.data.PasswordAuthenticationData;
import com.flabot.remotestorage.exception.AuthenticationException;
import com.flabot.remotestorage.exception.InvalidAuthMethodException;


public class PasswordAuthenticator extends Authenticator {
	
	@Override
	public void authenticate(Authenticable auth, AuthenticationData authData) throws AuthenticationException, InvalidAuthMethodException {
		
		PasswordAuthenticable passwordAuth = null;
		try {
			passwordAuth = (PasswordAuthenticable) auth;
		} catch (ClassCastException e) {
			throw new InvalidAuthMethodException(auth.getClass() + " does not implement PasswordAuthenticable");
		}
		
		PasswordAuthenticationData pAuthData = (PasswordAuthenticationData) authData;
		
		passwordAuth.passwordAuthentication(pAuthData);
	}

}
