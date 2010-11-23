package com.flabot.remotestorage.auth.data;
import java.util.HashMap;
import java.util.Map;

import com.flabot.remotestorage.auth.constants.AuthenticationConstants;
import com.flabot.remotestorage.properties.ProtocolsProperties;

public class DropboxAuthenticationData extends AuthenticationData {

	//Variables con valores por defecto - por lo general no cambian
	private String server = "api.dropbox.com";
	private String content_server = "api-content.dropbox.com/0/files/dropbox";
	private String request_token_url = "http//api.dropbox.com/0/token";
	private String access_token_url = "http//api.dropbox.com/0/auth/access_token";
	private String authorization_url = "http://api.dropbox.com/0/oauth/authorize";
	private String copy_url = "http://api.dropbox.com/0/fileops/copy";
	private String create_folder_url = "http://api.dropbox.com/0/fileops/create_folder";
	private String delete_url = "http://api.dropbox.com/0/fileops/delete";
	private String move_url = "http://api.dropbox.com/0/fileops/move";
	private String port = "80";
	
	//Variables a establecer
	private String consumer_key = "";
	private String consumer_secret = "";
	private String username = "";
	private String password = "";
	
	public DropboxAuthenticationData(){
		this.setType(AuthenticationConstants.DROPBOX_AUTHENTICATION);
	}

	@SuppressWarnings("unchecked")
	public Map getProperties(){
		Map props = new HashMap();
		props.put("server", getServer());
		props.put("content_server", getContent_server());
		props.put("request_token_url", getRequest_token_url());
		props.put("access_token_url", getAccess_token_url());
		props.put("authorization_url", getAuthorization_url());
		props.put("copy_url", getCopy_url());
		props.put("create_folder_url", getCreate_folder_url());
		props.put("delete_url", getDelete_url());
		props.put("move_url", getMove_url());
		props.put("port", getPort());
		props.put("consumer_key", getConsumer_key());
		props.put("consumer_secret", getConsumer_secret());
		props.put("username", getUsername());
		props.put("password", getPassword());
		return props;
	}
	
	public void setConsumer_key(String consumer_key) {
		this.consumer_key = consumer_key;
	}

	public String getConsumer_key() {
		return consumer_key;
	}

	public void setConsumer_secret(String consumer_secret) {
		this.consumer_secret = consumer_secret;
	}

	public String getConsumer_secret() {
		return consumer_secret;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	/**
	 * Ya posee un valor por defecto
	 * @param server String
	 */
	public void setServer(String server) {
		this.server = server;
	}

	public String getServer() {
		return server;
	}

	/**
	 * Ya posee un valor por defecto
	 * @param content_server String
	 */
	public void setContent_server(String content_server) {
		this.content_server = content_server;
	}

	public String getContent_server() {
		return content_server;
	}

	/**
	 * Ya posee un valor por defecto
	 * @param request_token_url String
	 */
	public void setRequest_token_url(String request_token_url) {
		this.request_token_url = request_token_url;
	}

	public String getRequest_token_url() {
		return request_token_url;
	}

	/**
	 * Ya posee un valor por defecto
	 * @param access_token_url String
	 */
	public void setAccess_token_url(String access_token_url) {
		this.access_token_url = access_token_url;
	}

	public String getAccess_token_url() {
		return access_token_url;
	}

	/**
	 * Ya posee un valor por defecto
	 * @param authorization_url String
	 */
	public void setAuthorization_url(String authorization_url) {
		this.authorization_url = authorization_url;
	}

	public String getAuthorization_url() {
		return authorization_url;
	}

	/**
	 * Ya posee un valor por defecto
	 * @param copy_url String
	 */
	public void setCopy_url(String copy_url) {
		this.copy_url = copy_url;
	}

	public String getCopy_url() {
		return copy_url;
	}

	/**
	 * Ya posee un valor por defecto
	 * @param create_folder_url String
	 */
	public void setCreate_folder_url(String create_folder_url) {
		this.create_folder_url = create_folder_url;
	}

	public String getCreate_folder_url() {
		return create_folder_url;
	}

	/**
	 * Ya posee un valor por defecto
	 * @param delete_url String
	 */
	public void setDelete_url(String delete_url) {
		this.delete_url = delete_url;
	}

	public String getDelete_url() {
		return delete_url;
	}

	/**
	 * Ya posee un valor por defecto
	 * @param move_url String
	 */
	public void setMove_url(String move_url) {
		this.move_url = move_url;
	}

	public String getMove_url() {
		return move_url;
	}

	/**
	 * Ya posee un valor por defecto
	 * @param port String
	 */
	public void setPort(String port) {
		this.port = port;
	}

	public String getPort() {
		return port;
	}
}
