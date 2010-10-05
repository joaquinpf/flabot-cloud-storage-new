package com.flabot.remotestorage.storageservice;
import com.flabot.remotestorage.auth.data.AuthenticationData;

public class StorageServiceData {

	private String host;
	private String path = "";
	private String fileName;
	private AuthenticationData authData;

	public String getPathFile() {
		return path + "/" + fileName;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public AuthenticationData getAuthData() {
		return authData;
	}

	public void setAuthData(AuthenticationData authData) {
		this.authData = authData;
	}

}