package com.flabot.remotestorage.storageservice;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
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
import org.apache.log4j.FileAppender;
import org.eclipse.debug.core.sourcelookup.containers.LocalFileStorage;

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
			HttpResponse resp = client.getFile("", "directory/" + data.getPath() + "/" + data.getFileName());
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
			copyfile(localPathFile, data.getFileName());
			HttpResponse resp = client.putFile("", "directory/" + data.getPath(),new File(data.getFileName()));
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
			TrustedAuthenticator auth = new TrustedAuthenticator(authData.getProperties());
			if (auth.retrieveTrustedAccessToken(authData.getUsername(), 
					authData.getPassword()))
			{
				this.client = new DropboxClient(authData.getProperties(),auth);
			}
		} catch (Exception e) {
			throw new AuthenticationException(e.getMessage());
		}
		
	}
	
	private static void copyfile(String srFile, String dtFile){
	    try{
	      File f1 = new File(srFile);
	      File f2 = new File(dtFile);
	      InputStream in = new FileInputStream(f1);
	      
	      //For Overwrite the file.
	      OutputStream out = new FileOutputStream(f2);

	      byte[] buf = new byte[1024];
	      int len;
	      while ((len = in.read(buf)) > 0){
	        out.write(buf, 0, len);
	      }
	      in.close();
	      out.close();
	      System.out.println("File copied.");
	    }
	    catch(FileNotFoundException ex){
	      System.out.println(ex.getMessage() + " in the specified directory.");
	      System.exit(0);
	    }
	    catch(IOException e){
	      System.out.println(e.getMessage());      
	    }
	  }
}
