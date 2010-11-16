package com.flabot.remotestorage.auth.authenticable;
import com.flabot.remotestorage.auth.data.AmazonAuthenticationData;
import com.flabot.remotestorage.exception.AuthenticationException;



public interface AmazonAuthenticable extends Authenticable {
	
	public void amazonAuthentication(AmazonAuthenticationData authData) throws AuthenticationException;
	
}
