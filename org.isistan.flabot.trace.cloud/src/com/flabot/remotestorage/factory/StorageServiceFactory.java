package com.flabot.remotestorage.factory;

import java.util.HashMap;
import java.util.Map;

import com.flabot.remotestorage.auth.authenticator.AmazonAuthenticator;
import com.flabot.remotestorage.auth.authenticator.Authenticator;
import com.flabot.remotestorage.auth.authenticator.PasswordAuthenticator;
import com.flabot.remotestorage.auth.authenticator.DropboxAuthenticator;
import com.flabot.remotestorage.auth.constants.AuthenticationConstants;
import com.flabot.remotestorage.storageservice.S3StorageService;
import com.flabot.remotestorage.storageservice.StorageService;
import com.flabot.remotestorage.storageservice.DropboxStorageService;
import com.flabot.remotestorage.storageservice.constants.StorageServiceConstants;

public class StorageServiceFactory {

	private Map<String,StorageServiceBuilder> storageServiceBuilders;
	private Map<String,AuthenticatorBuilder> authenticatorBuilders;
	
	public static StorageServiceFactory instance = new StorageServiceFactory();
	
	protected StorageServiceFactory() {			
		storageServiceBuilders = new HashMap<String,StorageServiceBuilder>();
		storageServiceBuilders.put(StorageServiceConstants.S3_STORAGE_SERVICE, new StorageServiceBuilder(){
			@Override
			public StorageService createStorageService(){
				StorageService service = new S3StorageService();
				return service;
			}
		});
		storageServiceBuilders.put(StorageServiceConstants.DROPBOX_STORAGE_SERVICE, new StorageServiceBuilder(){
			@Override
			public StorageService createStorageService(){
				StorageService service = new DropboxStorageService();
				return service;
			}
		});
		
		authenticatorBuilders = new HashMap<String,AuthenticatorBuilder>();
		authenticatorBuilders.put(AuthenticationConstants.AMAZON_AUTHENTICATION, new AuthenticatorBuilder(){
			@Override
			public Authenticator createAuthenticator(){
				Authenticator authenticator = new AmazonAuthenticator();
				return authenticator;
			}
		});	
		authenticatorBuilders.put(AuthenticationConstants.PASSWORD_AUTHENTICATION, new AuthenticatorBuilder(){
			@Override
			public Authenticator createAuthenticator(){
				Authenticator authenticator = new PasswordAuthenticator();
				return authenticator;
			}
		});
		authenticatorBuilders.put(AuthenticationConstants.DROPBOX_AUTHENTICATION, new AuthenticatorBuilder(){
			@Override
			public Authenticator createAuthenticator(){
				Authenticator authenticator = new DropboxAuthenticator();
				return authenticator;
			}
		});	
	}
	
	public StorageService getStorageService(String storageServiceKey) throws Exception {
		try {
			return storageServiceBuilders.get(storageServiceKey).createStorageService();
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public Authenticator getAuthenticator(String authMethodKey) throws Exception {
		try {
			return authenticatorBuilders.get(authMethodKey).createAuthenticator();
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}