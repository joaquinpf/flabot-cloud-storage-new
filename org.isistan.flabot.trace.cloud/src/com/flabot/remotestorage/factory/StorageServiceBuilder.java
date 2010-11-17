package com.flabot.remotestorage.factory;

import com.flabot.remotestorage.storageservice.StorageService;

public interface StorageServiceBuilder {

	public StorageService createStorageService();

}
