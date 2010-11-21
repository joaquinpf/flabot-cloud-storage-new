package org.isistan.flabot.trace.cloud.launcher.cloudProvider;

public interface CloudProvider {

	public void save(String key, String secret, String filename, String path, String localFilename) throws Exception;
	public void load(String key, String secret, String filename, String path, String localFilename) throws Exception;
	
}
