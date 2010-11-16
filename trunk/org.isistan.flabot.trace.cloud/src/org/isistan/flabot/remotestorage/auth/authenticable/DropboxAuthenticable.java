package com.flabot.remotestorage.auth.authenticable;
import com.flabot.remotestorage.exception.AuthenticationException;
import com.flabot.remotestorage.auth.data.DropboxAuthenticationData;;


public interface DropboxAuthenticable extends Authenticable {

	public void dropboxAuthentication(DropboxAuthenticationData authData) throws AuthenticationException;

}



