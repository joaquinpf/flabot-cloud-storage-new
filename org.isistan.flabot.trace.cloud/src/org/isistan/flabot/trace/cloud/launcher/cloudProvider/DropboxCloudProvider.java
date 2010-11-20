package org.isistan.flabot.trace.cloud.launcher.cloudProvider;

import org.isistan.flabot.remotestorage.auth.authenticator.Authenticator;
import org.isistan.flabot.remotestorage.auth.constants.AuthenticationConstants;
import org.isistan.flabot.remotestorage.auth.data.DropboxAuthenticationData;
import org.isistan.flabot.remotestorage.factory.StorageServiceFactory;
import org.isistan.flabot.remotestorage.storageservice.StorageService;
import org.isistan.flabot.remotestorage.storageservice.StorageServiceData;
import org.isistan.flabot.remotestorage.storageservice.constants.StorageServiceConstants;

public class DropboxCloudProvider implements CloudProvider {

	@Override
	public void load(String key, String secret, String filename, String path, String localFilename) {
		try{
			DropboxAuthenticationData authData = new DropboxAuthenticationData();
			StorageServiceData storageData = new StorageServiceData();
			storageData.setFileName(filename);
			int barra = path.indexOf("/");
			storageData.setHost(path.substring(0, barra - 1));
			storageData.setPath(path.substring(barra));
			storageData.setAuthData(authData);
			StorageService service = StorageServiceFactory.instance.getStorageService(StorageServiceConstants.DROPBOX_STORAGE_SERVICE);
			Authenticator authenticator = StorageServiceFactory.instance.getAuthenticator(AuthenticationConstants.DROPBOX_AUTHENTICATION);
			service.connect(storageData, authenticator);
			service.upload(localFilename, storageData);
			service.disconnect();		
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void save(String key, String secret, String filename, String path, String localFilename) {
		try{
			DropboxAuthenticationData authData = new DropboxAuthenticationData();
			StorageServiceData storageData = new StorageServiceData();
			storageData.setFileName(filename);
			int barra = path.indexOf("/");
			storageData.setHost(path.substring(0, barra - 1));
			storageData.setPath(path.substring(barra));
			storageData.setAuthData(authData);
			StorageService service = StorageServiceFactory.instance.getStorageService(StorageServiceConstants.DROPBOX_STORAGE_SERVICE);
			Authenticator authenticator = StorageServiceFactory.instance.getAuthenticator(AuthenticationConstants.DROPBOX_AUTHENTICATION);
			service.connect(storageData, authenticator);
			service.upload(localFilename, storageData);
			service.disconnect();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
