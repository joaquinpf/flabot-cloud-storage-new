package com.flabot.remotestorage.auth.authenticator;
import com.flabot.remotestorage.auth.authenticable.Authenticable;
import com.flabot.remotestorage.auth.data.AuthenticationData;
import com.flabot.remotestorage.exception.AuthenticationException;
import com.flabot.remotestorage.exception.InvalidAuthMethodException;


public abstract class Authenticator {
	
	public abstract void authenticate(Authenticable auth, AuthenticationData authData) throws AuthenticationException, InvalidAuthMethodException;
	
}
