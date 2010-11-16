package com.flabot.remotestorage.auth.authenticator;

import com.flabot.remotestorage.auth.authenticable.Authenticable;
import com.flabot.remotestorage.auth.authenticable.DropboxAuthenticable;
import com.flabot.remotestorage.auth.data.AuthenticationData;
import com.flabot.remotestorage.auth.data.DropboxAuthenticationData;
import com.flabot.remotestorage.exception.AuthenticationException;
import com.flabot.remotestorage.exception.InvalidAuthMethodException;

public class DropboxAuthenticator  extends Authenticator {
	@Override
	public void authenticate(Authenticable auth, AuthenticationData authData) throws AuthenticationException, InvalidAuthMethodException {
		
		DropboxAuthenticable dropboxAuth = null;
		try {
			dropboxAuth = (DropboxAuthenticable) auth;
		} catch (ClassCastException e) {
			throw new InvalidAuthMethodException(auth.getClass() + " does not implement DropboxAuthenticable");
		}
		
		DropboxAuthenticationData pAuthData = (DropboxAuthenticationData) authData;
		
		dropboxAuth.dropboxAuthentication(pAuthData);
	}
}