package com.flabot.remotestorage.factory;

import com.flabot.remotestorage.auth.authenticator.Authenticator;

public interface AuthenticatorBuilder {

	public Authenticator createAuthenticator();

}
