package com.flabot.remotestorage.storageservice;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import com.flabot.remotestorage.auth.authenticable.AmazonAuthenticable;
import com.flabot.remotestorage.auth.authenticable.DropboxAuthenticable;
import com.flabot.remotestorage.auth.authenticable.PasswordAuthenticable;
import com.flabot.remotestorage.auth.authenticator.Authenticator;
import com.flabot.remotestorage.auth.data.AmazonAuthenticationData;
import com.flabot.remotestorage.auth.data.DropboxAuthenticationData;
import com.flabot.remotestorage.auth.data.PasswordAuthenticationData;
import com.flabot.remotestorage.exception.AuthenticationException;
import com.flabot.remotestorage.exception.ConnectionException;
import com.flabot.remotestorage.exception.DownloadException;
import com.flabot.remotestorage.exception.InexistentBucketException;
import com.flabot.remotestorage.exception.UploadException;
import com.flabot.remotestorage.properties.ProtocolsProperties;
import com.dropbox.client.DropboxClient;
import com.dropbox.client.TrustedAuthenticator;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.BasicResponseHandler;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthException;

public class DropboxStorageService extends StorageService implements DropboxAuthenticable {

	private DropboxClient client = null;
	
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
		data.setPath(getRealPath(data.getPath()));
		try {
			HttpResponse resp = client.getFile("", "directory/" + data.getFileName());
			if (resp.getStatusLine().getStatusCode() != 200) {
				System.out.println("Ocurrio un error al recibir el archivo desde el repositorio." 
						+ resp.getStatusLine().getReasonPhrase() + " : " 
						+ resp.getStatusLine().getStatusCode());
				throw new UploadException("Ocurrio un error al recibir el archivo desde el repositorio."
						+ resp.getStatusLine().getReasonPhrase() + " : " 
						+ resp.getStatusLine().getStatusCode());
			}
			System.out.println("Archivo recibido exitosamente.");

			BasicResponseHandler brh = new BasicResponseHandler();
			String res = brh.handleResponse(resp);
			byte currentXMLBytes[] = res.getBytes();
			InputStream inputStream = new ByteArrayInputStream(currentXMLBytes);

			OutputStream out = new FileOutputStream(localPathFile);
			byte buf[] = new byte[1024];
			int len;
			while ((len = inputStream.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			inputStream.read();
			out.close();
			inputStream.close();
			
		} catch (Exception e) {
			throw new DownloadException(e.getMessage());
		}
	}
	
	@Override
	public void upload(String localPathFile, StorageServiceData data) throws UploadException {
		data.setPath(getRealPath(data.getPath()));
		try {
			HttpResponse resp = client.putFile("", "directory",new File(localPathFile));
			if (resp.getStatusLine().getStatusCode() != 200) {
				System.out.println("Ocurrio un error mientras se enviaba el archivo al repositorio." 
						+ resp.getStatusLine().getReasonPhrase() + " : " 
						+ resp.getStatusLine().getStatusCode());
				throw new UploadException("Ocurrio un error mientras se enviaba el archivo al repositorio."
						+ resp.getStatusLine().getReasonPhrase() + " : " 
						+ resp.getStatusLine().getStatusCode());
			} else
				System.out.println("Archivo enviado exitosamente.");
		} catch (Exception e) {
			throw new UploadException(e.getMessage());
		}		
	}

	private String getRealPath(String path) {
		if (path.endsWith("/"))
			path = path.substring(0, path.length() - 1);
		if (path.startsWith("/"))
			path = path.substring(1);

		return path;
	}

	@Override
	public void dropboxAuthentication(DropboxAuthenticationData authData)
			throws AuthenticationException {
		try {
			ProtocolsProperties props = authData.getProperties();
			TrustedAuthenticator auth = new TrustedAuthenticator(props);
			if (auth.retrieveTrustedAccessToken(props.getProperty("dropbox.username"), 
					props.getProperty("dropbox.password")))
			{
				this.client = new DropboxClient(props,auth);
			}
		} catch (Exception e) {
			throw new AuthenticationException(e.getMessage());
		}
		
	}
	
}
