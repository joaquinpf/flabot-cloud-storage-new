package com.flabot.remotestorage.auth.authenticator;


import com.flabot.remotestorage.auth.authenticable.AmazonAuthenticable;
import com.flabot.remotestorage.auth.authenticable.Authenticable;
import com.flabot.remotestorage.auth.data.AmazonAuthenticationData;
import com.flabot.remotestorage.auth.data.AuthenticationData;
import com.flabot.remotestorage.exception.AuthenticationException;
import com.flabot.remotestorage.exception.InvalidAuthMethodException;


public class AmazonAuthenticator extends Authenticator {
	
	@Override
	public void authenticate(Authenticable auth, AuthenticationData authData) throws AuthenticationException, InvalidAuthMethodException {

		AmazonAuthenticable awsAuth = null;
		try {
			awsAuth = (AmazonAuthenticable) auth;
		} catch (ClassCastException e) {
			throw new InvalidAuthMethodException(auth.getClass() + " does not implement AmazonAuthenticable");
		}
		
		AmazonAuthenticationData awsAuthData = (AmazonAuthenticationData) authData;

		awsAuth.amazonAuthentication(awsAuthData);
	}

}
