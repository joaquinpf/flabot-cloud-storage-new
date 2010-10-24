package org.isistan.flabot.trace.cloud.launcher.cloudProvider;

import com.flabot.remotestorage.auth.authenticator.Authenticator;
import com.flabot.remotestorage.auth.constants.AuthenticationConstants;
import com.flabot.remotestorage.auth.data.AmazonAuthenticationData;
import com.flabot.remotestorage.factory.StorageServiceFactory;
import com.flabot.remotestorage.storageservice.StorageService;
import com.flabot.remotestorage.storageservice.StorageServiceData;
import com.flabot.remotestorage.storageservice.constants.StorageServiceConstants;

public class S3CloudProvider implements CloudProvider {

	@Override
	public void load(String key, String secret, String filename, String path, String localFilename) {
		try{
			AmazonAuthenticationData authData = new AmazonAuthenticationData();
			authData.setAccessKey(key);
			authData.setSecretKey(secret);
			StorageServiceData storageData = new StorageServiceData();
			storageData.setFileName(filename);
			int barra = path.indexOf("/");
			storageData.setHost(path.substring(0, barra - 1));
			storageData.setPath(path.substring(barra));
			storageData.setAuthData(authData);
			StorageService service = StorageServiceFactory.instance.getStorageService(StorageServiceConstants.S3_STORAGE_SERVICE);
			Authenticator authenticator = StorageServiceFactory.instance.getAuthenticator(AuthenticationConstants.AMAZON_AUTHENTICATION);
			service.connect(storageData, authenticator);
			service.download(localFilename, storageData);
			service.disconnect();		
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void save(String key, String secret, String filename, String path, String localFilename) {
		try{
			AmazonAuthenticationData authData = new AmazonAuthenticationData();
			authData.setAccessKey(key);
			authData.setSecretKey(secret);
			StorageServiceData storageData = new StorageServiceData();
			storageData.setFileName(filename);
			int barra = path.indexOf("/");
			storageData.setHost(path.substring(0, barra - 1));
			storageData.setPath(path.substring(barra));
			storageData.setAuthData(authData);
			StorageService service = StorageServiceFactory.instance.getStorageService(StorageServiceConstants.S3_STORAGE_SERVICE);
			Authenticator authenticator = StorageServiceFactory.instance.getAuthenticator(AuthenticationConstants.AMAZON_AUTHENTICATION);
			service.connect(storageData, authenticator);
			service.upload(localFilename, storageData);
			service.disconnect();		
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
