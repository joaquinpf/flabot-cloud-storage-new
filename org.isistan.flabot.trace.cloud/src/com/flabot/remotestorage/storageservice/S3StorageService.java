package com.flabot.remotestorage.storageservice;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.jets3t.service.S3ServiceException;
import org.jets3t.service.acl.AccessControlList;
import org.jets3t.service.acl.GroupGrantee;
import org.jets3t.service.acl.Permission;
import org.jets3t.service.impl.rest.httpclient.RestS3Service;
import org.jets3t.service.model.S3Bucket;
import org.jets3t.service.model.S3Object;
import org.jets3t.service.multithread.S3ServiceSimpleMulti;
import org.jets3t.service.security.AWSCredentials;
import org.jets3t.service.utils.ObjectUtils;

import com.flabot.remotestorage.auth.authenticable.AmazonAuthenticable;
import com.flabot.remotestorage.auth.authenticable.PasswordAuthenticable;
import com.flabot.remotestorage.auth.authenticator.Authenticator;
import com.flabot.remotestorage.auth.data.AmazonAuthenticationData;
import com.flabot.remotestorage.auth.data.PasswordAuthenticationData;
import com.flabot.remotestorage.exception.AuthenticationException;
import com.flabot.remotestorage.exception.ConnectionException;
import com.flabot.remotestorage.exception.DownloadException;
import com.flabot.remotestorage.exception.InexistentBucketException;
import com.flabot.remotestorage.exception.UploadException;

public class S3StorageService extends StorageService implements AmazonAuthenticable, PasswordAuthenticable {

	private RestS3Service s3Service = null;
	
	@Override
	public void connect(StorageServiceData data, Authenticator authenticator) throws ConnectionException {
		try {
			authenticator.authenticate(this, data.getAuthData());
		} catch (Exception e) {
			throw new ConnectionException(e.getMessage());
		}
	}


	@Override
	public void disconnect() {
		
	}

	@Override
	public void download(String localPathFile, StorageServiceData data) throws DownloadException {
		
		data.setPath(sanitizeAmazonPath(data.getPath()));

		try {
			S3Bucket bucket = connectToS3Bucket(data);

			S3Object fileObject;
			try {
				String s3keys[] = { data.getPath() + data.getFileName() };
				S3ServiceSimpleMulti serviceSimpleMulti = new S3ServiceSimpleMulti(s3Service);
				fileObject = serviceSimpleMulti.getObjects(bucket, s3keys)[0];

				InputStream inputStream = fileObject.getDataInputStream();
				OutputStream out = new FileOutputStream(localPathFile);
				byte buf[] = new byte[1024];
				int len;
				while ((len = inputStream.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
				inputStream.read();
				out.close();
				inputStream.close();
			} catch (IOException e) {
				throw new DownloadException(e.getMessage());
			}

		} catch (Exception e) {
			throw new DownloadException(e.getMessage());
		}
	}
	
	@Override
	public void upload(String localPathFile, StorageServiceData data) throws UploadException {
		
		data.setPath(sanitizeAmazonPath(data.getPath()));
		
		try {
			S3Bucket bucket = connectToS3Bucket(data);

			S3Object fileObject;
			try {
				fileObject = ObjectUtils.createObjectForUpload(data.getPath() + data.getFileName(), new File(localPathFile), null, false);
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new UploadException(e.getMessage());
			}

			AccessControlList listAcl = s3Service.getBucketAcl(bucket);
			listAcl.grantPermission(GroupGrantee.ALL_USERS, Permission.PERMISSION_READ);
			fileObject.setAcl(listAcl);

			s3Service.putObject(bucket, fileObject);
			
		} catch (UploadException e) {
			throw e;
		} catch (Exception e) {
			throw new UploadException(e.getMessage());
		}		
	}

	private S3Bucket connectToS3Bucket(StorageServiceData data) throws InexistentBucketException, S3ServiceException {
		if (s3Service.isBucketAccessible(data.getHost())) {
			return new S3Bucket(data.getHost());
		} else {
			throw new InexistentBucketException("Bucket not exists");
		}
	}


	private String sanitizeAmazonPath(String path) {
		if (path.startsWith("/"))
			path = path.substring(1);
		if (!path.endsWith("/"))
			path = path + "/";
		
		return path;
	}


	@Override
	public void passwordAuthentication(PasswordAuthenticationData authData) throws AuthenticationException {
		AWSCredentials credentials = new AWSCredentials(authData.getUsername(), authData.getPassword());
		try {
			s3Service = new RestS3Service(credentials);
		} catch (S3ServiceException e) {
			throw new AuthenticationException(e.getMessage());
		}		
	}

	@Override
	public void amazonAuthentication(AmazonAuthenticationData authData) throws AuthenticationException {
		AWSCredentials credentials = new AWSCredentials(authData.getAccessKey(), authData.getSecretKey());
		try {
			s3Service = new RestS3Service(credentials);
		} catch (S3ServiceException e) {
			throw new AuthenticationException(e.getMessage());
		}
		
	}
	
}
