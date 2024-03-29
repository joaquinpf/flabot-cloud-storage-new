package org.isistan.flabot.trace.cloud.launcher.cloudProvider;

import java.util.Map;

import com.flabot.remotestorage.auth.authenticator.Authenticator;
import com.flabot.remotestorage.auth.constants.AuthenticationConstants;
import com.flabot.remotestorage.auth.data.DropboxAuthenticationData;
import com.flabot.remotestorage.factory.StorageServiceFactory;
import com.flabot.remotestorage.storageservice.StorageService;
import com.flabot.remotestorage.storageservice.StorageServiceData;
import com.flabot.remotestorage.storageservice.constants.StorageServiceConstants;

public class DropboxCloudProvider implements CloudProvider {

	@Override
	public void load(Map<String,String> properties) throws Exception {
		try{
			String key = properties.get(CloudProviderPropertiesConstants.KEY);
			String secret = properties.get(CloudProviderPropertiesConstants.SECRET);
			String path = properties.get(CloudProviderPropertiesConstants.PATH);
			String filename = properties.get(CloudProviderPropertiesConstants.FILE_NAME);
			String localFilename = properties.get(CloudProviderPropertiesConstants.LOCAL_FILE_NAME);
			String username = properties.get(CloudProviderPropertiesConstants.USER_NAME);
			String password = properties.get(CloudProviderPropertiesConstants.PASSWORD);
			
			DropboxAuthenticationData authData = new DropboxAuthenticationData();
			authData.setConsumer_key(key);
			authData.setConsumer_secret(secret);
			authData.setUsername(username);
			authData.setPassword(password);

			StorageServiceData storageData = new StorageServiceData();
			storageData.setFileName(filename);
			storageData.setAuthData(authData);
			storageData.setPath(path);
			StorageService service = StorageServiceFactory.instance.getStorageService(StorageServiceConstants.DROPBOX_STORAGE_SERVICE);
			Authenticator authenticator = StorageServiceFactory.instance.getAuthenticator(AuthenticationConstants.DROPBOX_AUTHENTICATION);
			service.connect(storageData, authenticator);
			service.upload(localFilename, storageData);
			service.disconnect();		
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void save(Map<String,String> properties) throws Exception {
		try{
			String key = properties.get(CloudProviderPropertiesConstants.KEY);
			String secret = properties.get(CloudProviderPropertiesConstants.SECRET);
			String path = properties.get(CloudProviderPropertiesConstants.PATH);
			String filename = properties.get(CloudProviderPropertiesConstants.FILE_NAME);
			String localFilename = properties.get(CloudProviderPropertiesConstants.LOCAL_FILE_NAME);
			String username = properties.get(CloudProviderPropertiesConstants.USER_NAME);
			String password = properties.get(CloudProviderPropertiesConstants.PASSWORD);
			
			
			DropboxAuthenticationData authData = new DropboxAuthenticationData();
			authData.setConsumer_key(key);
			authData.setConsumer_secret(secret);
			authData.setUsername(username);
			authData.setPassword(password);
			StorageServiceData storageData = new StorageServiceData();
			storageData.setFileName(filename);
			storageData.setAuthData(authData);
			storageData.setPath(path);
			StorageService service = StorageServiceFactory.instance.getStorageService(StorageServiceConstants.DROPBOX_STORAGE_SERVICE);
			Authenticator authenticator = StorageServiceFactory.instance.getAuthenticator(AuthenticationConstants.DROPBOX_AUTHENTICATION);
			service.connect(storageData, authenticator);
			service.upload(localFilename, storageData);
			service.disconnect();
		} catch (Exception e) {
			throw e;
		}
	}

}
