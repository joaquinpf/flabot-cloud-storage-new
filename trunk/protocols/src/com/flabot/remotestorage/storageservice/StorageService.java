package com.flabot.remotestorage.storageservice;

import com.flabot.remotestorage.auth.authenticable.Authenticable;
import com.flabot.remotestorage.auth.authenticator.Authenticator;
import com.flabot.remotestorage.exception.ConnectionException;
import com.flabot.remotestorage.exception.DownloadException;
import com.flabot.remotestorage.exception.UploadException;


public abstract class StorageService implements Authenticable {

	public abstract void download(String localPathFile, StorageServiceData data) throws DownloadException;

	public abstract void upload(String localPathFile, StorageServiceData data) throws UploadException;

	public abstract void connect(StorageServiceData data, Authenticator authenticator) throws ConnectionException;

	public abstract void disconnect();
}
