package com.flabot.remotestorage.auth.data;
import com.flabot.remotestorage.auth.constants.AuthenticationConstants;
import com.flabot.remotestorage.properties.ProtocolsProperties;

public class DropboxAuthenticationData extends AuthenticationData {

	private ProtocolsProperties props;
	
	public DropboxAuthenticationData(){
		this.props = new ProtocolsProperties(null);
		this.setType(AuthenticationConstants.DROPBOX_AUTHENTICATION);
	}

	public DropboxAuthenticationData(String path){
		this.props = new ProtocolsProperties(path);
		this.setType(AuthenticationConstants.DROPBOX_AUTHENTICATION);
	}
	
	public ProtocolsProperties getProperties() {
		return props;
	}
}
