package com.flabot.remotestorage.auth.data;

import com.flabot.remotestorage.auth.constants.AuthenticationConstants;

public class AmazonAuthenticationData extends AuthenticationData {

	private String accessKey = "";
	private String secretKey = "";
	
	public AmazonAuthenticationData(){
		this.setType(AuthenticationConstants.AMAZON_AUTHENTICATION);
	}
	public String getAccessKey() {
		return accessKey;
	}
	public String getSecretKey() {
		return secretKey;
	}
	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
}
